def config = new groovy.json.JsonSlurper().parseText(readFileFromWorkspace('JenkinsJobs/JobDSL.json'))
def STREAMS = config.Streams

def ARCHS = ['aarch64', 'x86_64']
def ARCHS_JOB_NAME = ['aarch64': 'macM1', 'x86_64': 'mac64'] // preserve old job labels for now, to affect all downstream scripts
def ARCHS_AGENT_LABEL = ['aarch64': 'nc1ht-macos11-arm64', 'x86_64': 'nc1ht-macos11-arm64']
def ARCHS_JAVA_HOME = ['aarch64': '/usr/local/openjdk-17/Contents/Home', 'x86_64': '/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home']

for (STREAM in STREAMS){
for (ARCH in ARCHS){
  def MAJOR = STREAM.split('\\.')[0]
  def MINOR = STREAM.split('\\.')[1]

  pipelineJob('AutomatedTests/ep' + MAJOR + MINOR + 'I-unit-' + ARCHS_JOB_NAME[ARCH] + '-java17'){
    description('Run Eclipse SDK Tests for the platform implied by this job\'s name')
    parameters { // Define parameters in job configuration to make them available from the very first build onwards
      stringParam('buildId', null, 'Build Id to test (such as I20240611-1800, N20120716-0800).')
    }

    authenticationToken('windows2012tests')
 
    definition {
      cps {
        sandbox()
        script('''
pipeline {
  options {
    timeout(time: 600, unit: 'MINUTES')
    timestamps()
    buildDiscarder(logRotator(numToKeepStr:'5'))
  }
  agent {
    label '&&AGENT_LABEL&&'
  }

  stages {
      stage('Run tests'){
          environment {
              // Declaring a jdk and ant the usual way in the 'tools' section, because of unknown reasons, breaks the usage of system commands like xvnc, pkill and sh
              JAVA_HOME = '&&JAVA_HOME&&'
              ANT_HOME = '/opt/homebrew/Cellar/ant/1.10.11/libexec'
              PATH = "${JAVA_HOME}/bin:${ANT_HOME}/bin:${PATH}"
              eclipseArch = '&&ARCH&&'
          }
          steps {
              cleanWs() // workspace not cleaned by default
              sh \'\'\'#!/bin/bash -x
RAW_DATE_START="$(date +%s )"

echo -e "\\n\\tRAW Date Start: ${RAW_DATE_START} \\n"

echo -e "\\n\\t whoami:  $( whoami )\\n"
echo -e "\\n\\t uname -a: $(uname -a)\\n"

# unset commonly defined system variables, which we either do not need, or want to set ourselves.
# (this is to improve consistency running on one machine versus another)
echo "Unsetting variables: JAVA_BINDIR JAVA_ROOT JDK_HOME JRE_HOME CLASSPATH"
unset -v JAVA_BINDIR JAVA_ROOT JDK_HOME JRE_HOME CLASSPATH

# 0002 is often the default for shell users, but it is not when ran from
# a cron job, so we set it explicitly, to be sure of value, so releng group has write access to anything
# we create on shared area.
oldumask=$(umask)
umask 0002
echo "umask explicitly set to 0002, old value was $oldumask"

# we want java.io.tmpdir to be in $WORKSPACE, but must already exist, for Java to use it.
mkdir -p tmp

curl -o getEBuilder.xml https://download.eclipse.org/eclipse/relengScripts/production/testScripts/hudsonBootstrap/getEBuilder.xml 2>&1
cat getEBuilder.xml
curl -o buildProperties.sh https://download.eclipse.org/eclipse/downloads/drops4/$buildId/buildproperties.shsource
cat getEBuilder.xml
source buildProperties.sh

echo JAVA_HOME: $JAVA_HOME
echo ANT_HOME: $ANT_HOME
echo PATH: $PATH

env  1>envVars.txt 2>&1
ant -diagnostics  1>antDiagnostics.txt 2>&1
java -XshowSettings -version  1>javaSettings.txt 2>&1

ant -f getEBuilder.xml -Djava.io.tmpdir=${WORKSPACE}/tmp -DbuildId=$buildId -DeclipseStream=$STREAM -DEBUILDER_HASH=${EBUILDER_HASH} \\
  -DdownloadURL=https://download.eclipse.org/eclipse/downloads/drops4/${buildId} \\
  -Dosgi.os=macosx -Dosgi.ws=cocoa -Dosgi.arch=${eclipseArch} \\
  -DtestSuite=all

RAW_DATE_END="$(date +%s )"

echo -e "\\n\\tRAW Date End: ${RAW_DATE_END} \\n"

TOTAL_TIME=$((${RAW_DATE_END} - ${RAW_DATE_START}))

echo -e "\\n\\tTotal elapsed time: ${TOTAL_TIME} \\n"
              \'\'\'
              archiveArtifacts '**/eclipse-testing/results/**, **/eclipse-testing/directorLogs/**, *.properties, *.txt'
              junit keepLongStdio: true, testResults: '**/eclipse-testing/results/xml/*.xml'
              build job: 'Releng/ep-collectResults', wait: false, parameters: [
                string(name: 'triggeringJob', value: "${JOB_BASE_NAME}"),
                string(name: 'buildURL', value: "${BUILD_URL}"),
                string(name: 'buildID', value: "${params.buildId}")
              ]
          }
      }
  }
}
        '''.replace('&&ARCH&&', ARCH).replace('&&AGENT_LABEL&&', ARCHS_AGENT_LABEL[ARCH]).replace('&&JAVA_HOME&&', ARCHS_JAVA_HOME[ARCH]))
      }
    }
  }
}
}
