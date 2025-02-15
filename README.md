Aggregator repo -- for -- Eclipse SDK builds
======================================

* uses
  * build the Eclipse SDK / 👀provides the 👀
    * framework for Eclipse based applications,
    * Java development tooling
    * Plug-in development tooling

Requirements to build
------------------

* Java v17+
* Maven v3.5.4+
* see [Platform Build wiki](https://wiki.eclipse.org/Platform-releng/Platform_Build)
* recommendations
  * use 
    * toolchains.xml
    * -Pbree-libs
      * see [Using BREE Libs](https://wiki.eclipse.org/Platform-releng/Platform_Build#Using_BREE_Libs "Using BREE Libs")

How to build the Eclipse SDK?
----------------------------

```
# clean up "dirt" from previous build see Bug 420078
git submodule foreach git clean -f -d -x
git submodule foreach git reset --hard HEAD
git clean -f -d -x
git reset --hard HEAD

# update master and submodules
git checkout master
git pull --recurse-submodules
git submodule update

# run the build
mvn clean verify  -DskipTests=true

# find the results in
# eclipse.platform.releng.tychoeclipsebuilder/eclipse.platform.repository/target/products
```
  * `-DskipTests=true`
    * Reason: 🧠tests can take <= 10 hours 🧠

How to build + custom compiler?
--------------------------

```
# compile local version
mvn clean install -f eclipse.jdt.core/org.eclipse.jdt.core.compiler.batch -DlocalEcjVersion=99.99

# run build with local compiler
mvn clean verify  -DskipTests=true -Dcbi-ecj-version=99.99
```

Integration builds
------------------

* hosted | [Jenkins instance](https://ci.eclipse.org/releng/job/Builds/) 
* job / highest release number -> builds nightly SDK
  * _Example:_ [job for Eclipse v4.27 SDK](https://ci.eclipse.org/releng/job/Builds/job/I-build-4.27/)
* [build artifacts & test results](https://download.eclipse.org/eclipse/downloads/)
* if the tests fail to start -> [test jobs / EACH platform](https://ci.eclipse.org/releng/view/Builds/job/AutomatedTests/) 
* if the build is successful BUT SDK is broken & should NOT be used -> build is marked as unstable -- via -- [this job](https://ci.eclipse.org/releng/job/Builds/job/markUnstable/) 
* [weekly maven snapshots](https://repo.eclipse.org/content/repositories/eclipse-snapshots/) -- [built | Jenkins](https://ci.eclipse.org/releng/view/Publish%20to%20Maven/)

Milestone and release tasks
-----------------
* see [Releng-Tasks 2.0](RELEASE.md)

Performance Tests
-----------------
* see [Performance README.md](production/README.md)

How to contribute
-----------------

* see [here](https://github.com/eclipse-platform/.github/blob/main/CONTRIBUTING.md)

Additional information
-----------------------

* [Automated Platform Builds](https://wiki.eclipse.org/Platform-releng/Automated_Platform_Build "Automated Platform Builds")
* [Releng Wiki](https://wiki.eclipse.org/Category:Eclipse_Platform_Releng "Releng Wiki")

License
-------

* [Eclipse Public License (EPL) v2.0](https://www.eclipse.org/legal/epl-2.0/)
