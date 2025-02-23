# The Eclipse Runtime Options

* Eclipse platform
  * HIGHLY configurable
* Configuration input's form == 
  * CL arguments' form
    * CL arguments == (NORMALLY) System properties' short cuts
  * System property settings' form

## CL Arguments
* 👀-- are processed by -- various parts of the Eclipse runtime 👀
* ALTERNATIVES to it
  * system properties | CL -- via -- -D VM arguments
    * argument == {systemProperty}
  * "config.ini" file
  * "<launcher>.ini" file

* `-application <id> (Runtime)`
  * == `eclipse.application <id>`
* `-arch <architecture> (OSGi)` 
  * == `osgi.arch <architecture>`
* `-clean (OSGi)` 
  * == `osgi.clean "true"`
* -clearPersistedState (E4)
  * Removes any cached state of the user interface and reloads the model</dd>
* -configuration <location>   (Main)
  * == <a href="#osgiconfigurationarea">osgi.configuration.area</a>
      to <location></dd>
* -console [[host:]port] (OSGi) 
  * == <a href="#osgiconsole">osgi.console</a> to [[host:]port].</dd>
* -consoleLog (Runtime)
  * == <a href="#eclipseconsolelog">eclipse.consoleLog</a> to
      &quot;true&quot;</dd>
* -data <location>    (OSGi)
  * == <a href="#osgiinstancearea">osgi.instance.area</a>
      to <location></dd>
* `-debug [options file] (OSGi)`
  * == `osgi.debug`
  * if == `""` -> enable debug
* -dev [entries] (OSGi)
  * == <a href="#osgidev">osgi.dev</a> to [entries] or
      the empty string to simply enable dev mode (i.e., if entries are not specified)</dd>
    <a name="eclipsekeyring"></a>-eclipse.keyring <file path>    (Equinox)
  * Set to override the location of the default secure storage.
      If specified, this parameter takes precedence over setting the
      <a href="#env.eclipsekeyring"><code>ECLIPSE_KEYRING</code></a> environment variable.</dd>
* -eclipse.password <file path>    (Equinox)
  * If specified, the secure storage treats contents of the file as a default password.
      When not set, password providers are used to obtain a password.</dd>
* -feature <feature id>    (Runtime)
  * ==  <a href="#eclipseproduct">eclipse.product</a>
      to <feature id></dd>
* -framework <location> (Main) 
  * ==  <a href="#o.pngramework">osgi.framework</a> to
      <location></dd>
* -initialize (Main)
  * initializes the configuration being run. All runtime related data structures
      and caches are refreshed. Any user/plug-in defined configuration data is
      not purged. No application is run, any product specifications are ignored
      and no UI is presented (e.g., the splash screen is not drawn)</dd>
* -install <location> (Main)
  * ==  <a href="#osgiinstallarea">osgi.install.area</a> to
      <location></dd>
    <a name="launcherdefaultaction" id="launcherdefaultaction"></a>--launcher.defaultAction <option> (Executable)
  * specifies the default action to take when the launcher is started without
    any &quot;-&quot; arguments on the command line.  Currently the only supported
    value is &quot;openFile&quot;.  The &quot;openFile&quot; option tells the
    launcher that if it is called with a command line that only contains arguments
    that do not start with &quot;-&quot;, then those arguments should be treated as if they
    followed &quot;--launcher.openFile&quot;.
    <pre>  eclipse myFile.txt</pre>
    This is the kind of command line the launcher will receive on windows when you double click a
    file that is associated with eclipse, or you select and choose &quot;Open With&quot; or
    &quot;Send To&quot; Eclipse.
    </dd>

    <a name="launcheropenfile" id="launcheropenfile"></a>--launcher.openFile <space separated list of files> (Executable)
  * a space separated list of files to pass to the application.  This option is
    typically used to pass a list of files to be opened by an Eclipse application.
    This option requires SWT in order to fire the necessary SWT_OPENDOC event for
    the files that are specified.  Relative paths will be resolved first against the current
    working directory, and second against the eclipse program directory.</dd>
    --launcher.library <location> (Executable)
  * the location of the eclipse executable's companion shared
library.&nbsp; If not specified the executable looks in the plugins
directory for the appropriate org.eclipse.equinox.launcher.[platform]
fragment with the highest version and uses the shared library named
eclipse_* inside.</dd>
  --launcher.ini <location> (Executable)
  <dd>the location of the product .ini file to use.&nbsp; If not
specified the executable will look for a file beside the launcher with
the same name and the extension .ini.&nbsp; (i.e. eclipse.exe looks for
eclipse.ini, product.exe looks for product.ini)</dd>
  --launcher.suppressErrors (Executable)
  <dd>If specified the executable will not display any error or message
dialogs.&nbsp; This is useful if the executable is being used in an
unattended situation.</dd>
  --launcher.noRestart (Executable)
  <dd>If specified, the special handling of exit codes 23 (restart) and 24
(relaunch) is disabled and they are treated as regular exit codes. This can be
useful for non-IDE/command-line applications.</dd>
  --launcher.secondThread (Executable)&nbsp; <span
 style="font-style: italic;">MACOSX ONLY</span>
  <dd>If specified the executable will create the Java VM on a
secondary thread.&nbsp; This should used if a swing application is
being run. <span style="font-weight: bold;">SWT will NOT work</span>
if this option is specified.</dd>
  <a name="launchertimeout" id="launchertimeout"></a>--launcher.timeout <value> (Executable)
  <dd>a timeout value for how long the launcher should spend trying to
  communicate with an already running eclipse before the launcher gives up and
  launches a new eclipse instance. Default is 60 (seconds).
  </dd>
  --launcher.XXMaxPermSize <value> (Executable)
  <dd>If specified, and the executable detects that the VM being used
is a Sun VM, then the launcher will automatically add the
-XX:MaxPermSize=<value> vm argument.&nbsp; The executable is not
capable of detecting Sun VMs on all platforms.<br>
  </dd>
  --launcher.appendVmargs (Executable)
  <dd>If specified, any VM arguments on the commandline will be appended
  to any VM arguments specified in the launcher .ini file.
  <span style="font-weight: bold;">Using this option is recommended</span>
  in every launcher .ini file that specifies VM arguments, because the
  default behavior of overriding VM arguments can have unexpected side-effects.</dd>
  --launcher.overrideVmargs (Executable)
  <dd>If specified on the commandline, overrides the effect of
  --launcher.appendVmargs in a launcher .ini file such that none
  of the VM arguments in the .ini file are considered as soon as
  a -vmargs option is detected on the commandline.</dd>
  -name <string>
  <dd>The name to be displayed in the task bar item for the splash screen when the application starts up (not applicable on Windows).
  Also used as the title of error dialogs opened by the launcher.  When not set, the name is the name of the executable.</dd>
  -nl <locale> (OSGi)
  <dd>== <a href="#osginl">osgi.nl</a> to <locale></dd>
  -nlExtensions <nlExtensions> (OSGi)
  <dd>indicates NL extensions and is ==
    <a href="#osginlextensions">osgi.nl.extensions</a> to <nlExtensions></dd>
  -noExit (OSGi)
  <dd>== <a href="#osginoshutdown">osgi.noShutdown</a> to &quot;true&quot;</dd>
  -noLazyRegistryCacheLoading (Runtime) 
  <dd>== <a href="#eclipsenolazyregistrycacheloading">eclipse.noLazyRegistryCacheLoading</a>
    to &quot;true&quot;</dd>
  -noRegistryCache
    (Runtime) 
  <dd>==  <a href="#eclipsenoregistrycache">eclipse.noRegistryCache</a>
  to &quot;true&quot;</dd>
  -noSplash (Executable, Main)
  <dd>controls whether or not the splash screen is shown</dd>
  -os <operating system> (OSGi) 
  <dd>==  <a href="#osgios">osgi.os</a> to <operating system></dd>
   -pluginCustomization <location> (Runtime) 
  <dd>== <a href="#eclipseplugincustomization">eclipse.pluginCustomization</a> to
  <location></dd>
   -product <id> (OSGi) 
  <dd>==  <a href="#eclipseproduct">eclipse.product</a> to
  <id></dd>
  -protect [root, master] (Executable, Main) 
  <dd>setting the value to "root" prevents Eclipse from being started
  as a root user, either directly or via programs that run with administrative privileges like 'sudo'.
  This option is currently implemented only on Linux/UNIX based platforms. "master" can be used to
  prevent starting of the master instance in a shared install configuration. This option can be used
  on all platforms supported by Eclipse.</dd>
   -registryMultiLanguage  (Runtime) 
  <dd>== <a href="#registrymultilang">eclipse.registry.MultiLanguage</a> to
  &quot;true&quot;</dd>
  -showSplash <bitmap> (Executable, Main)
  
  <dd>specifies the bitmap to use in the splash screen. If specified,
the launcher may be able to show the splash screen before starting the
Java VM.&nbsp; If not specified, Main will find the bitmap using the
osgi.splashLocation and osgi.splashPath properties.<br>
  </dd>
  -startup <location> (Executable)
  <dd>The location of jar used to startup eclipse. The jar referred to
should have the Main-Class attribute set to
org.eclipse.equinox.launcher.Main. If this parameter is not set, the
executable will look in the plugins directory for
theorg.eclipse.equinox.launcher bundle with the highest version.<br>
  </dd>
  -user <location> (OSGi) 
  <dd>== <a href="#osgiuserarea">osgi.user.area</a> to <location></dd>
  -vm <path to java vm> (Executable, Main) 
  <dd>when passed to the Eclipse executable, this option is used to
locate the Java VM to use to run Eclipse. It should be the full file
system path to an appropriate: Java jre/bin directory, Java Executable,
Java shared library (jvm.dll or libjvm.so), or a Java VM Execution
Environment description file.&nbsp; If not specified,
the Eclipse executable uses a search algorithm to locate a suitable VM.
In any event, the executable then passes the path to the actual VM used
to Java Main using the -vm argument. Java Main then stores this value
in <a href="#eclipsevm">eclipse.vm</a>.</dd>
  -vmargs [vmargs*] (Executable,
    Main) 
  <dd>when passed to the Eclipse, this option is used to customize the operation
    of the Java VM to use to run Eclipse. If
    specified, this option must come at the end of the command line. Even if
    not specified on the executable command line, the executable will automatically
    add the relevant arguments (including the class being launched) to the command
    line passed into Java using the -vmargs argument.
    Java Main then stores this value in <a href="#eclipsevmargs">eclipse.vmargs</a>.</dd>
  -ws <window system> (OSGi) 
  <dd>==  <a href="#osgiws">osgi.ws</a> to <window system></dd>
</dl>
<h3>Bidirectional Support</h3>
<dl>
  -dir <dir>
  <dd>indicates the orientation of the workbench and is ==
    <a href="#eclipseorientation">eclipse.orientation</a> to <dir>.</dd>
  -bidi <value>
  <dd>Indicates the default base text direction and whether special bidi processing
    should be enabled.</dd>
  <dd>Valid arguments are <b>&quot;on=[y|n];textDir=[ltr|rtl|auto]&quot;,</b>.</dd>
  <dd>Example: <b>-bidi &quot;on=y;textDir=rtl&quot;</b></dd>
 </dl>
<h3>Obsolete Command Line Arguments </h3>
<p>The following command line arguments are no longer relevant or have been superseded
  and are consumed by the runtime and not passed on to the application being
  run to maintain backward compatibility. .</p>
<dl>
   -boot
  <dd>see -configuration</dd>
  -classLoaderProperties
  <dd>no longer relevant</dd>
  -endSplash <command> <br>
  
  <dd>no longer relevant<br>
  </dd>
  -firstUse
  <dd>no longer relevant</dd>
  -newUpdates
  <dd>no longer relevant</dd>
  -noPackagePrefixes
  <dd>no longer relevant</dd>
  -noUpdate
  <dd>no longer relevant</dd>
  -plugins
  <dd>no longer relevant</dd>
  -update
  <dd>no longer relevant</dd>
</dl>
<h3>Others</h3>
<p>The following command line arguments are defined by various Eclipse plug-ins
  and are only supported if the defining plug-in is installed, resolved and activated.</p>
<dl>
  -noVersionCheck (workbench)
  <dd><description></dd>
  -perspective (workbench)
  <dd>launch Eclipse and switch to the perspective with the given id. As an example, for JDT perspective, we read the
     <a href="../../../org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/ui/JavaUI.html">JDT APIs</a>,
     to find the ID_PERSPECTIVE is <code>"org.eclipse.jdt.ui.JavaPerspective"</code>.</dd>
  -refresh (org.eclipse.core.resources)
  <dd><description></dd>
  -showLocation (org.eclipse.ui.ide.workbench)
  <dd>shows the workspace path in the window title bar.  Overrides the corresponding setting in the 'Workspace'
      preference page.  Optionally a custom path can be given as a second argument.</dd>
  -allowDeadlock
  <dd><description></dd>
</dl>

## System Properties
<p>The following System properties are used by the Eclipse runtime. Note that
  those starting with &quot;osgi&quot; are specific to the OSGi framework implementation
  while those starting with &quot;eclipse&quot; are particular to the Eclipse
  runtime layered on top of the OSGi framework. </p>
<p>Many of these properties have command line equivalents (see the <a href="#commandline">command
    line arguments</a> section and the value in braces {}). Users are free to
    use either command line or property settings to specify a value. Properties
    can
    be set
  in
  the
  following
  ways:</p>
<ul>
  <li>use -DpropName=propValue as a VM argument to the Java VM</li>
  <li>set the desired property in the config.ini file in the appropriate configuration
    area</li>
</ul>

  <a name="activateRuntimePlugins" id="activateRuntimePlugins"></a>eclipse.activateRuntimePlugins
  <dd>controls activation of runtime plug-ins. RCP applications not requiring services provided by runtime
    plug-ins can set this property to &quot;false&quot; to avoid activation of runtime plug-ins on Eclipse startup</dd>
  <a name="eclipseallowAppRelaunch" id="eclipseallowAppRelaunch"></a>eclipse.allowAppRelaunch
  <dd>if set to &quot;true&quot; then the main thread will continue to  wait for another application descriptor to be
  launched after the currently running application has quit.  Stopping the system.bundle (i.e. the bundle with a
  bundle ID equal to zero) will force the main thread to stop waiting for another application to launch.
  The default value is &quot;false&quot;</dd>
  <a name="eclipseapplication" id="eclipseapplication"></a>eclipse.application {-application}
  <dd>the identifier of the application to run. The value given here overrides
    any application defined by the product (see <a href="#eclipseproduct">eclipse.product</a>) being run</dd>
  <a name="eclipseapplicationlaunchdefault" id="eclipseapplicationlaunchdefault"></a>eclipse.application.launchDefault
  <dd>Controls launching the default application automatically once the platform is running.  A default application is identified
  by the <a href="#eclipseproduct">eclipse.product</a> or the <a href="#eclipseapplication">eclipse.application</a>
  options.  The default value is &quot;true&quot;.  Setting this property to &quot;false&quot; will prevent the default
  application from launching automatically.  Once the platform is running the main thread will wait for an application to be
  launched using an application descriptor service.</dd>
  <a name="eclipseapplicationregisterDescriptors"  id="eclipseapplicationregisterDescriptors"></a>eclipse.application.registerDescriptors
  <dd>Controls registration of application descriptor services for all installed applications.  The default value is
  &quot;false&quot;.  If set to &quot;false&quot; only the default application will have an application descriptor service
  registered.  If set to &quot;true&quot; then all installed applications will have an application descriptor service registered.</dd>
  <a name="eclipsecommands" id="eclipsecommands"></a>eclipse.commands
  <dd>a new-line separated list of all command-line arguments passed in when launching
    Eclipse </dd>
  <a name="eclipseconsolelog" id="eclipseconsolelog"></a>eclipse.consoleLog
  <dd>if &quot;true&quot;, any log output is also sent to Java's System.out (typically
    back to the command shell if any). Handy when combined with -debug </dd>
  <a name="eclipsedebugstartuptime" id="eclipsedebugstartuptime"></a>eclipse.debug.startupTime
  <dd>the time in milliseconds when the Java VM for this session was started</dd>
  <a name="eclipseeeinstallverify" id="eclipseeeinstallverify"></a>eclipse.ee.install.verify
  <dd>if set to &quot;true&quot; then the framework will check the required execution
    environment at bundle install time.  The default value is &quot;false&quot;.</dd>
  <a name="eclipseexitOnError" id="eclipseexitOnError"></a>eclipse.exitOnError
  <dd>if set to &quot;true&quot; then the platform will exit if an unhandled error occurs.  The default value is
  &quot;true&quot;.</dd>
  <a name="eclipseignoreApp" id="eclipseignoreApp"></a>eclipse.ignoreApp
  <dd>if set to &quot;true&quot; then the main launching thread will not start the default application and
  will proceed in shutting down the platform and exiting.
  The default value is &quot;false&quot;.  This is different than the
  <a href="#eclipseapplicationlaunchdefault">eclipse.application.launchDefault</a> option because the main thread will
  not wait for an application descriptor service to be launched.</dd>
  <a name="eclipseloglevel" id="eclipseloglevel"></a>eclipse.log.level
  <dd>
    sets the level used when logging messages to the eclipse log.
    <ul type="disc">
      <li><b>ERROR</b> - enables logging only ERROR messages.</li>
      <li><b>WARNING</b> - enables logging of ERROR and WARNING messages.</li>
      <li><b>INFO</b> - enables logging of ERROR, WARNING and INFO messages.</li>
      <li><b>ALL</b> - enables logging of all messages (default value)</li>
    </ul>
  </dd>
  <a name="eclipselogbackupmax" id="eclipselogbackupmax"></a>eclipse.log.backup.max
  <dd>the max number of backup log files to allow.  The oldest backup log file will be deleted
     after the max number of backup log files is reached as a result of rotating the log file.
     The default value is &quot;10&quot;.  A negative or zero value will cause the default
     value to be used.</dd>
  <a name="eclipselogsizemax" id="eclipselogsizemax"></a>eclipse.log.size.max
  <dd>the max size in Kb that the log file is allowed to grow.  The log file is rotated when
     the file size exceeds the max size.  The default value is &quot;1000&quot;.
     A negative value will cause the default value to be used.  A zero value indicates
     no max log size.</dd>
  <a name="eclipsenoextensionmunging" id="eclipsenoextensionmunging"></a>eclipse.noExtensionMunging
  <dd>if &quot;true&quot;, legacy registry extension are left as-is. By default such extensions
    are updated to use the new extension point ids found in Eclipse 3.0.</dd>
  <a name="eclipsenolazyregistrycacheloading" id="eclipsenolazyregistrycacheloading"></a>eclipse.noLazyRegistryCacheLoading {-noLazyRegistryCacheLoading}
  <dd>if &quot;true&quot;, the platform's plug-in registry cache loading optimization is
      deactivated. By default, configuration elements are loaded from the registry
      cache (when available)
      only on demand, reducing memory footprint. This option forces the registry
  cache to be fully loaded at startup. </dd>
  <a name="eclipsenoregistrycache" id="eclipsenoregistrycache"></a>eclipse.noRegistryCache {-noRegistryCache}
  <dd>if &quot;true&quot;, the internal extension registry cache is neither read or written</dd>
  <a name="eclipseplugincustomization" id="eclipseplugincustomization"></a>eclipse.pluginCustomization {-pluginCustomization}
  <dd>the file system location of a properties file containing default settings
      for plug-in preferences. These default settings override default settings
      specified in the primary feature. Relative paths are interpreted relative
  to the current working directory for Eclipse itself.</dd>
  <a name="eclipseproduct" id="eclipseproduct"></a>eclipse.product {-product}
  <dd>the identifier of the product being run. This controls various branding
  information and what application is used.</dd>
  <a name="registrymultilang" id="registrymultilang"></a>eclipse.registry.MultiLanguage {-registryMultiLanguage}
  <dd>if &quot;true&quot;, extension registry supports translation to multiple languages. By default extension registry provides
  translation only to the Eclipse locale specified by the <a href="#osginl">osgi.nl</a>.</dd>
  <a name="serviceJobs" id="serviceJobs"></a>eclipse.service.jobs
  <dd>controls registration of OSGi services. Set to &quot;false&quot; to suppress registration of OSGi
    services by the <code>org.eclipse.core.jobs</code> plug-in</dd>
  <a name="servicePref" id="servicePref"></a>eclipse.service.pref
  <dd>Controls registration of OSGi services. Set to &quot;false&quot; to suppress registration of OSGi
     services by the <code>org.eclipse.equinox.preferences</code> plug-in</dd>
  <a name="eclipsestarttime" id="eclipsestarttime"></a>eclipse.startTime
  <dd>This property is set at the time Eclipse is started.  The value of this property a string
      representation of the value returned by System.currentTimeMillis().  This value is not
      intended to be set by users.</dd>
  <a name="eclipsestateSaveDelayInterval" id="eclipsestateSaveDelayInterval"></a>eclipse.stateSaveDelayInterval
  <dd>the delay interval (in milliseconds) for persisting state change requests.  The default
    is 30000 ms (30 seconds).  State change requests are delayed to prevent massive amounts
    of disk writes while performing administrative operations (e.g. installing bundles).
    The delay interval is used to wait for a period of inactivity before persisting the
    framework state information.</dd>
  <a name="eclipsesecurity"></a>eclipse.security
  <dd>specifies that a security policy and manager should be configured when the framework is launched.  If the launcher is used (org.eclipse.equinox.launcher)
   and this property is set to any value then the launcher will configure a java.security.Policy that grants all permissions to the launcher
   and the framework.  When the framework is launched it will use this property to determine the security manager to use.  If set to <b>osgi</b>
   then the Equinox security manager is used.  This security manager is required to fully support the OSGi Conditional Permission Admin specification.  If
   the property is set to the empty string then java.lang.SecurityManager will be used; otherwise the property specifies a security manager
   class that should be used as the security manager.</dd>
  <a name="eclipsetracesizemax"></a>eclipse.trace.size.max <span style="font-style: italic;">NEW</span>
  <dd>the max size in Kb that the trace file is allowed to grow. The trace file is rotated when the file size exceeds the max size.
  The default value is "1000". A negative value will cause the default value to be used. A zero value indicates no max trace size.</dd>
  <a name="eclipsetracebackupmax"></a>eclipse.trace.backup.max <span style="font-style: italic;">NEW</span>
  <dd>the max number of backup trace files to allow. The oldest backup trace file will be deleted after the max number of backup trace
  files is reached as a result of rotating the trace file. The default value is "10". A negative or zero value will cause the default value to be used.</dd>
  <a name="eclipsevm" id="eclipsevm"></a>eclipse.vm {-vm}
  <dd>the path to the Java executable used to run Eclipse. This information is
  used to construct relaunch command lines.</dd>
  <a name="eclipsevmargs" id="eclipsevmargs"></a>eclipse.vmargs {-vmargs}
  <dd>lists the VM arguments used to run Eclipse. This
      information is used to construct relaunch command
  lines.</dd>
  <a name="eclipseorientation" id="eclipseorientation"></a>eclipse.orientation {-dir}
  <dd>the workbench orientation which can be <b>ltr</b> (left-to-right) or <b>rtl</b> (right-to-left).</dd>
  <a name="equinoxsecurityvm"></a>equinox.security.vm
  <dd>If set to &quot;server&quot;, security modules will not attempt to substitute VM's JAAS processing.</dd>
  <a name="swtreportNonDisposed"></a>org.eclipse.swt.graphics.Resource.reportNonDisposed
  <dd>If set to &quot;true&quot;, <a href="PLUGINS_ROOT/org.eclipse.platform.doc.isv/guide/swt_graphics.htm#swtreportNonDisposed">non-disposed SWT Resources</a> will be logged.</dd>
  <a name="osgiadaptor"></a>osgi.adaptor
  <dd>the class name of the OSGi framework adaptor to use.</dd>
  <a name="osgiarch"></a>osgi.arch {-arch}
  <dd>the processor architecture value. The value should be one of the processor architecture
  names known to Eclipse (e.g., x86, ppc, sparc, ...). See <tt>org.eclipse.osgi.service.environment.Constants</tt> for known values.</dd>
  <a name="osgibaseconfigurationarea"></a>osgi.baseConfiguration.area
  <dd>specifies a base configuration that is used when
      <a href="#osgiconfigurationarea">osgi.configuration.area</a> is not specified.</dd>
  <a name="osgibundlefilelimit"></a>osgi.bundlefile.limit
  <dd>specifies a limit on the number of jar files the framework will keep open.
      The minimum value allowed is 10.  Any value less than 10 will disable the
      bundle file limit, making the the number of jar files the framework
      keeps open unlimited.  By default the value is 100.</dd>
      
* `osgi.bundles`
  * == `bundle1, bundle2, bundle3, ...`
    * `bundlei` == `<URL | simpleBundleLocation>[@ [<start-level>] [":start"]]`
      * 👀`<start-level>`
        * == OSGi start level | bundle should run 👀
        * if it's omitted -> framework -- will use the -- default start level
      * if `start` is added -> | AFTER being installed, bundle -- will be marked as -- started 
      * `simpleBundleLocation`
        * == -- relative to the -- framework's parent directory
        * -> search -- finds the -- highest version available
        * `reference:`
          * ONLY -- can be used to refer a -- file
            * _Example:_ `reference:file:/path/to/mybundle_1.0.0.jar`
          * if the bundle is a directory -> `file:` NOT supported, use `reference:file:`
            * _Example:_ ❌`file:/path/to/myDirectoryBundle_1.0.0/` NOT❌, use `reference:file:/path/to/myDirectoryBundle_1.0.0/` 
  * == bundles / 
    * | system is up & running,
      * AUTOMATICALLY installed
      * OPTIONALLY started

* `osgi.bundles.defaultStartLevel`
  * == bundle's start-level | bundles -- installed by -- Eclipse Update
  * bundles / specified | `osgi.bundles` -> can specify a particular startlevel
  * 👀by default, == 4 👀

* `osgi.compatibility.bootdelegation`
  <dd>if set to &quot;true&quot; then the parent (boot by default) classloader is delegated to as a last resort if a
  class or resource cannot be found.  The default value is &quot;true&quot;.</dd>
  <a name="osgicompatibilityerrorOnFailedStart" id="osgicompatibilityerrorOnFailedStart"></a>osgi.compatibility.errorOnFailedStart
  <dd>A bundle may specify a lazy activation policy using the bundle manifest headers Eclipse-LazyStart or Bundle-ActivationPolicy.  According
  to the OSGi R4.1 specification, if a bundle with a lazy activation policy fails to start then class loads must still succeed.  Before the OSGi
  R4.1 specification Eclipse defined the lazy activation policy such that failed starts would cause class loading errors to be thrown.  If
  osgi.compatibility.errorOnFailedStart is set to &quot;true&quot; then failed starts will result in class loading errors; otherwise the
  activation error is logged and the classes are allowed to load from bundles which failed to start.  The default value is &quot;true&quot;.</dd>
  <a name="osgicompatibilityeagerStart.LazyActivation" id="osgicompatibilityeagerStart.LazyActivation"></a>osgi.compatibility.eagerStart.LazyActivation
  <dd>The OSGi R4.1 specification mandates that all bundles must be marked for start before they are allowed to activate.  This includes bundles
  which specify a lazy activation policy.  A new method Bundle.start(options) has been added to allow lazy activated bundles to be activated
  according to their lazy activation policy.  Before the OSGi R4.1 specification Eclipse defined the lazy activation policy such that
  lazy activated were automatically activated on first class load even though they were not marked for activation.
  If osgi.compatibility.eagerStart.LazyActivation is set to &quot;true&quot; then bundles with the lazy activation policy will automatically be
  marked for activation; otherwise bundles with the lazy activation policy must be started with the new Bundle.start(options) method before
  being allowed to lazy activate.  The default value is &quot;true&quot;.</dd>
  <a name="osgicheckConfiguration" id="osgicheckConfiguration"></a>osgi.checkConfiguration
  <dd>if set to &quot;true&quot; then timestamps are check in the configuration cache to ensure that the cache
  is up to date with respect to the contents of the installed bundles.  The default value is &quot;false&quot;.</dd>
  <a name="osgiclassloadersingleThreadLoads" id="osgiclassloadersingleThreadLoads"></a>osgi.classloader.singleThreadLoads
  <dd>if set to &quot;true&quot; then only one thread is allowed to load a class at a time.  The default value is
   &quot;false&quot;.  This option can be used to work around certain VM bugs which can cause deadlock.
   See <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=121737" target="_blank">bug 121737</a>.  Note that recent
   discussions in <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=227587" target="_blank">bug 227587</a> have shown
   that this option introduces another kind of deadlock.</dd>
  <a name="osgiclassloaderlock" id="osgiclassloaderlock"></a>osgi.classloader.lock
  <dd>
    the classloader locking strategy to use when defining classes.  The valid types are the following:
    <ul type="disc">
      <li><b>classname</b> - lock on the classname.</li>
      <li><b>classloader</b> - lock on the classloader (default value).</li>
    </ul>
    There are cases where bundle cycles may cause class loader deadlock to occur (see
    <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=229621" target="_blank">bug 229621</a>).  This option
    can be used to work around this deadlock by locking on the class name instead of the class loader
    when defining a class.  This option should be used with caution because some VMs still lock the
    class loader natively (e.g. the Sun VM).  When running on these kinds of VMs deadlock can still
    occur because of the VM lock.
  </dd>
  <a name="osgiclassloadercopynatives" id="osgiclassloadercopynatives"></a>osgi.classloader.copy.natives <span style="font-style: italic;">NEW</span>
  <dd>
    If set to &quot;true&quot; then native code which is loaded from a bundle will be copied to a unique
    location on disk each time a class loader asks to load the library from the bundle.  This may be needed in
    scenarios where the framework is restarted without shutting down the VM.  The default value is &quot;false&quot;.
  </dd>
  <a name="osgiclassloadertype" id="osgiclassloadertype"></a>osgi.classloader.type <span style="font-style: italic;">NEW</span>
  <dd>
    If set to &quot;parallel&quot; then a check is done on JavaSE 7 for the ClassLoader#registerAsParallelCapable
    method and if found then it is called to allow for parallel class loads.  On Java SE 7 this is the preferred
    way to avoid class loader deadlock because of cyclic class loaders.
  </dd>

* `osgi.clean`
  * if == "true" -> ANY cached data / used by the OSGi framework & eclipse runtime -- will be -- wiped clean
    * == caches / store bundle dependency resolution & eclipse extension registry data 
    * == eclipse -- will reinitialize -- these caches
  
<a name="osgiconfigurationcascaded"></a>osgi.configuration.cascaded
  <dd>if set to &quot;true&quot;, this configuration is cascaded to a parent
    configuration.  The parent configuration is specified by the <a href="#osgisharedconfigurationarea">osgi.sharedConfiguration.area</a>.
    See the section on <a href="#locations">locations</a> for more details.</dd>
  <a name="osgiconfigurationarea"></a>osgi.configuration.area {-configuration}
  <dd>the configuration location for this run of the platform. The configuration
    determines what plug-ins will run as well as various other system settings.
    See the section on <a href="#locations">locations</a>  for
    more details.</dd>
  <a name="osgiconfigurationareadefault" id="osgiconfigurationareadefault"></a>osgi.configuration.area.default
  <dd>the default configuration location for this run of the platform. The configuration
    determines what plug-ins will run as well as various other system settings.
    This value (i.e., the default setting) is only used if no value for the osgi.configuration.area
    is set. See the section on <a href="#locations">locations</a>  for
    more details.</dd>
  <a name="osgiconsole"></a>osgi.console {-console [[host:]port]} 
  <dd>if set to a non-null value, the OSGi console (if installed) is enabled.
    This is handy for investigating the state of the system.
    The value syntax is [[host:]port] where the port and optional host name specify which port
    and hostname on which the console listens and directs its output to.  If the value does not
    specify a valid port or hostname (including the empty string) then the console will
    listen to System.in and direct its output to System.out. In order for this option
    to be supported the Equinox console must be installed.  See <a href="../../guide/console_shell.htm">Console Shell</a>
    for more information.</dd>
  <a name="osgicontextClassLoaderParent"></a>osgi.contextClassLoaderParent
  <dd>the classloader type to use as the parent classloader of the context
    classloader used by the Framework.  The valid types are the following:
    <ul type="disc">
      <li><b>app</b> - the application classloader.</li>
      <li><b>boot</b> - the boot classloader.</li>
      <li><b>ext</b> - the extension classloader.</li>
      <li><b>fwk</b> - the framework classloader.</li>
      <li><b>ccl</b> - the original context classloader
     that was set when the framework launched (default value).</li>
    </ul>
  </dd>
  <a name="osgidataAreaRequiresExplicitInit"></a>osgi.dataAreaRequiresExplicitInit
  <dd>if &quot;true&quot;, don't allow clients to initialize instance location if the instance
    area is not explicitly defined yet. This prevents a plug-in that starts early from accessing
    the instance area before it has been configured by the osgi.instance.area setting.
    It is recommended to set osgi.dataAreaRequiresExplicitInit=true.
    See <a href="#osgiinstancearea">osgi.instance.area</a>.
  </dd>
 
* `osgi.debug {-debug}`
  * if
    * == NON-null value -> platform enabled in debug mode
    * == string -> ".options" file's location
      * see [here](https://wiki.eclipse.org/FAQ_How_do_I_use_the_platform_debug_tracing_facility)
      * == debug points AVAILABLE | plug-in
* `osgi.dev {-dev}`
    <dd>if set to the empty string, dev mode is simply turned on. This property
      may also be set to a comma-separated class path entries
      which are added to
      the class
      path of each
      plug-in or a URL to a Java properties file containing custom classpath additions
      for a set of plug-ins. For each plug-in requiring a customized dev time classpath
      the file will contain an entry of the form<br>
<pre>    <plug-in id>=<comma separated list of classpath entries to add></pre>
    where plug-in id &quot;*&quot; matches any plug-in not otherwise mentioned.</dd>
  <a name="osgifilepermissionscommand"></a>osgi.filepermissions.command
  <dd>specifies an optional OS specific command to set file permissions on extracted
      native code.  On some operating systems it is required that native libraries be
      set to executable.  This optional property allows you to specify the command.
      For example, on a UNIX style OS you could have the following value:
      <pre>    osgi.filepermissions.command=&quot;chmod +rx [fullpath]&quot;</pre>
      The [fullpath] is used to substitute the actual file path by the framework.
  </dd>
  <a name="o.pngramework"></a>osgi.framework
  <dd>the URL location of the OSGi framework. Useful if the Eclipse install
  is disjoint. See the section on <a href="#locations">locations</a> for more details. </dd>
  <a name="o.pngrameworkclasspath"></a>osgi.frameworkClassPath
  <dd>a comma separated list of classpath entries for the OSGi framework implementation.
    Relative locations are interpreted as relative to the framework location
    (see <a href="#o.pngramework">osgi.framework</a>)</dd>
  <a name="osgiframeworkextensions"></a>osgi.framework.extensions
  <dd>a comma-separated list of framework extensions.  Each entry is of the form:<br>
	 <pre>    <simple bundle location></pre>
      Simple bundle locations are searched in the parent directory of the
      org.eclipse.osgi bundle.  Framework extensions may be used to run Eclipse with a different
      framework adaptor.  The framework extension may contain an eclipse.properties file to set
      system properties.  For example, a framework extension that provides a framework adaptor
      implementation can specify what the adaptor class is by setting the
      <a href="#osgiadaptor">osgi.adaptor</a> property.</dd>
  <a name="osgiframeworkshape"></a>osgi.framework.shape
  <dd>set to the shape of the Eclipse OSGi Framework implementation.  This property is set when
  the Eclipse platform is started and is not intended by be set by the user.  The value
  &quot;jar&quot; indicates that the Eclipse OSGi Framework is contained in a single jar.
  The value &quot;folder&quot; indicates that the Eclipse OSGi Framework is contained in a
  directory.</dd>
  <a name="osgiframeworklibraryextensions"></a>osgi.framework.library.extensions
  <dd>a comma separated list of additional library file extensions that
    must be searched for.  If not set then only the library name returned by
    System.mapLibraryName(String) will be used to search.  This is needed for
    certain operating systems which allow more than one extension for a library.
    For example AIX allows library extensions of .a and .so, but
    System.mapLibraryName(String) will only return names with the .a extension.</dd>
  <a name="osgiframeworkParentClassloader"></a>osgi.frameworkParentClassloader
  <dd>the classloader type to use as the parent classloader for the the Framework.  The valid types are the following:
    <ul type="disc">
      <li><b>app</b> - the application classloader.</li>
      <li><b>boot</b> - the boot classloader.</li>
      <li><b>ext</b> - the extension classloader.</li>
      <li><b>current</b> - the classloader used to load the equinox launcher.</li>
    </ul>
  </dd>
  <a name="osgiframeworkactiveThreadType"></a>osgi.framework.activeThreadType
  <dd>
   if set to <b>normal</b> then an active framework thread is started when the framework is launched
   that monitors the lifecycle of the framework.  This thread is a non-daemon thread and is used to prevent
   the VM from shutting down when the framework is active and only daemon threads are active in the VM.
   When the framework is shutdown then the active framework thread will quit which should allow the VM to
   shutdown as long as no other non-deamon threads are active in the VM.  The default value is set to
   <b>normal</b>.  Setting this option to any other value besides <b>normal</b> will prevent the
   active framework thread from getting started when the framework is launched.
  </dd>
  <a name="osgiframeworkuseSystemProperties"></a>osgi.framework.useSystemProperties
  <dd>controls whether the framework properties are backed by the global System properties
    or held privately for each instance of the framework.  By default the framework properties
    are backed by the System properties (e.g. true).  This property is useful when running
    multiple instances of the OSGi Framework within the same VM and each instance has a separate
    set of configuration properties (e.g. set in the config.ini).</dd>
  <a name="osgigenericAliases"></a>osgi.genericAliases
  <dd>a comma separated list of generic aliases that can be used to map existing manifest
    headers onto Eclipse-GenericCapability and Eclipse-GenericRequire manifest headers.  The
    osgi.genericAliases property uses the following syntax:
    <pre>
  osgi.genericAliases ::= generic-alias ( ',' generic-alias ) *
  generic-alias       ::= capability-alias ':' require-alias ':' capability-type</pre>
    For example, to map the OSGi headers Export-Service and Import-Service headers
    onto Eclipse-GenericCapability and Eclipse-GenericRequire headers you would use
    the following value:
    <pre>  osgi.genericAliases=Export-Service:Import-Service:osgi.service</pre>
  </dd>
  <a name="osgihookconfigurators"></a>osgi.hook.configurators
  <dd>a comma separated list of hook configurators.  If this property is set then the list of
    configurators specified will be the only configurators used.  Any hook configurators
    specified in hookconfigurators.properties files will be ignored.</dd>
  <a name="osgihookconfiguratorsinclude"></a>osgi.hook.configurators.include
  <dd>a comma separated list of additional hook configurators.  This is helpful for
    configuring optional hook configurators.  This option is ignored if the
    <a href="#osgihookconfigurators">osgi.hook.configurators</a> option is used.</dd>
  <a name="osgihookconfiguratorsexclude"></a>osgi.hook.configurators.exclude
  <dd>a comma separated list of hook configurators to exclude.  This is helpful for disabling
    hook configurators that are specified in hook configurator properties files.  This option
    is ignored if the <a href="#osgihookconfigurators">osgi.hook.configurators</a> option is used.</dd>
  <a name="osgijavaprofile"></a>osgi.java.profile
  <dd>a URL to the JRE profile file to use.  The specified URL is read as a Java properties
     file.  A JRE profile contains values for the properties org.osgi.framework.system.packages,
     org.osgi.framework.bootdelegation and org.osgi.framework.executionenvironment.  If the
     osgi.java.profile is not set then a profile is selected based on the
     java.specification.version value of the running JRE.</dd>
  <a name="osgijavaprofilebootdelegation"></a>osgi.java.profile.bootdelegation
  <dd>
    a java profile <a href="#osgijavaprofile">osgi.java.profile</a> may contain a
    &quot;org.osgi.framework.bootdelegation&quot; property.  This value may be used to set the system
	property &quot;org.osgi.framework.bootdelegation&quot;.  The osgi.java.profile.bootdelegation
	indicates the policy for bootdelegation to be used.  The following values are valid
	(default is ignore):
    <ul type="disc">
      <li><b>ignore</b> - indicates that
          the &quot;org.osgi.framework.bootdelegation&quot; value in the java profile should be ignored.
          The system property &quot;org.osgi.framework.bootdelegation&quot; will be used to
          determine which packages should be delegated to boot.
      </li>
      <li><b>override</b> -
          indicates that the &quot;org.osgi.framework.bootdelegation&quot; in the java profile should
          override the system property &quot;org.osgi.framework.bootdelegation&quot;.
      </li>
      <li><b>none</b> -
          indicates that the &quot;org.osgi.framework.bootdelegation&quot; in the java profile AND
          the system properties should be ignored.  This is the most strict option.
          Running with this option causes the framework to use the OSGi R4 strict boot
          delegation model.
      </li>
    </ul>
  </dd>
  <a name="osgiinstallarea" id="osgiinstallarea"></a>osgi.install.area {-install}
  <dd>the install location of the platform. This setting indicates the location
    of the basic Eclipse plug-ins and is useful if the Eclipse install is disjoint.
  See the section on <a href="#locations">locations</a> for more details. </dd>
  <a name="osgiinstancearea"></a>osgi.instance.area {-data}
  <dd>the instance data location for this session. Plug-ins use this location
    to store their data. For example, the Resources plug-in uses this as the
    default location for projects (aka the workspace). See the section on <a href="#locations">locations</a> for
    more details. Set <a href="#osgidataAreaRequiresExplicitInit">osgi.dataAreaRequiresExplicitInit</a> to ensure
    that data area is explicitly initialized before plug-ins can use it.</dd>
  <a name="osgiinstanceareadefault" id="osgiinstanceareadefault"></a>osgi.instance.area.default
  <dd>the default instance data location for this session. Plug-ins use this
    location to store their data. For example, the Resources plug-in uses this
    as the
    default location for projects (aka the workspace). This value (i.e., the
    default setting) is only used if no value for the osgi.instance.area
    is set. See the section on <a href="#locations">locations</a> for
    more details.</dd>
  <a name="osgilocking"></a>osgi.locking
  <dd>the locking type to use for this run of the platform.  The valid locking types
  are &quot;java.io&quot;, &quot;java.nio&quot;, and &quot;none&quot;.  The default value is
  &quot;java.nio&quot; unless the JRE does not support &quot;java.nio&quot; then &quot;java.io&quot;
  is the default.</dd>
  <a name="osgimanifestcache"></a>osgi.manifest.cache
  <dd>the location where generated manifests are discovered and generated. The
    default is in the configuration area but the manifest cache can be stored
    separately.</dd>
  <a name="osginl"></a>osgi.nl {-nl}
  <dd>the name of the locale on which Eclipse platform will run. NL values should
    follow the standard Java locale naming conventions.</dd>
  <a name="osginlextensions"></a>osgi.nl.extensions {-nlExtensions}
  <dd>the NL extensions, such as collation rules (sorting, searching, grouping), calendar system (locale)
    and currency format. This is a list of <a href="http://userguide.icu-project.org/locale#TOC-Keywords">keyword</a>=value pairs. For example:
    <pre>-nlExtensions &quot;@collation=phonebook;calendar=hebrew;currency=USD&quot;</pre></dd>
  <a name="osginluser"></a>osgi.nl.user
  <dd>the name of the locale when the user explicitly adds -nl to the command-line arguments.</dd>
  <a name="osginoshutdown"></a>osgi.noShutdown {-noExit}
  <dd>if &quot;true&quot;, the OSGi Framework will not be shut down after the Eclipse application has ended.  This
      is useful for examining the OSGi Framework after the Eclipse application has ended.  Note that the VM will terminate
      if no active non-daemon threads exists. See <a href="#osgiframeworkactiveThreadType">osgi.framework.activeThreadType</a>.</dd>
  <a name="osgios"></a>osgi.os {-os}
  <dd>the operating system value. The value should be one of the operating system
  names known to Eclipse (e.g., win32, linux, ...). See <tt>org.eclipse.osgi.service.environment.Constants</tt> for known values.</dd>
  <a name="osgiparentclassloader"></a>osgi.parentClassloader
  <dd>the classloader type to use as the parent classloader for all bundles installed
  in the Framework.  The valid types are the following:
    <ul type="disc">
      <li><b>app</b> - the application classloader.</li>
      <li><b>boot</b> - the boot classloader.</li>
      <li><b>ext</b> - the extension classloader.</li>
      <li><b>fwk</b> - the framework classloader.</li>
    </ul>
  </dd>
  <a name="osgirequiredjavaversion"></a>osgi.requiredJavaVersion
  <dd>The minimum java version that is required to launch Eclipse.  The default value is
      &quot;1.4.1&quot;.</dd>
  <a name="osgiresolvermode"></a>osgi.resolverMode
  <dd>the mode used to resolve bundles installed in the Framework.  The default resolver
      mode is not strict.  The following options are available.
    <ul type="disc">
      <li><b>strict</b> - the resolver is in strict mode and will enforce access restriction rules when loading classes and resources from exported packages which specify the x-internal or x-friends directives.</li>
      <li><b>development</b> - used for development time resolution.  This mode disables certain resolver rules that are not needed at development time.  For example, singleton selection is disabled to allow the development of multiple versions of a singleton bundle</li>
    </ul>
  </dd>
  <a name="osgi.resolver.usesMode"></a>osgi.resolver.usesMode
  <dd>
    the resolver mode used to resolve <b>uses</b> directives on Export-Package statements.
     <ul type="disc">
      <li><b>aggressive</b> - aggressively seeks a solution with no class space inconsistencies (default value).  This mode may be very expensive depending on the number of bundles and number of duplicate exports in the system.</li>
      <li><b>tryFirst</b> - only tries the first solution selected by the resolver.  This mode is very fast but may result in unresolved bundles because of class space inconsistencies.</li>
      <li><b>ignore</b> - ignores all uses directives on exports.  This mode is very fast by may result in inconsistent class spaces in resolved bundles.</li>
    </ul>
  </dd>
  <a name="osgisharedconfigurationarea"></a>osgi.sharedConfiguration.area
  <dd>the shared configuration location for this run of the platform.  If the
  <a href="#osgiconfigurationcascaded">osgi.configuration.cascaded</a> property is set
  to &quot;true&quot; then shared configuration area is used as the parent configuration.</dd>
  <a name="osgisignedcontentsupport"></a>osgi.signedcontent.support
  <dd>A comma separated list of options for signed content support.  The valid types are the following:
    <ul type="disc">
      <li><b>certificate</b> - enables parsing and verification of certificates.</li>
      <li><b>trust</b> - enables verification of certificate trust.  This option implies
      &quot;certificate&quot;.</li>
      <li><b>runtime</b> - enables verification of signed bundle content at runtime.
      This option implies &quot;certificate&quot;.</li>
      <li><b>authority</b> - enables the default authorization engine.  This option implies &quot;certificate&quot; and &quot;trust&quot;..</li>
      <li><b>all</b> - same as &quot;certificate,trust,runtime,authority&quot;.</li>
    </ul>
  </dd>
  <a name="osgisignedcontenttrustengine"></a>osgi.signedcontent.trust.engine
  <dd>
  A service property key used to identify an implementation of the <b>org.eclipse.osgi.service.security.TrustEngine</b> service.
  A TrustEngine service should be registered with a unique value for this property to allow selection of the TrustEngine
  service implementation.  The <b>osgi.signedcontent.trust.engine</b> property can be used as a configuration
  property to select particular TrustEngine service implementations at runtime.  If this property is not set then
  all available TrustEngine services are used at runtime.
  </dd>
  <a name="osgisplashlocation"></a>osgi.splashLocation
  <dd>the absolute URL location of the splash screen (.bmp file) to to show while
    starting Eclipse. This property overrides any value set in <a href="#osgisplashpath">osgi.splashPath</a>.</dd>
  <a name="osgisplashpath"></a>osgi.splashPath
  <dd>a comma separated list of URLs to search for a file called splash.bmp.
  This property is overriden by any value set in <a href="#osgisplashlocation">osgi.splashLocation</a>.</dd>
  <a name="osgistartlevel"></a>osgi.startLevel
  <dd>the start level value the framework will be set to at startup.  The default value is 6.</dd>
  <a name="osgistrictbundleentrypath"></a>osgi.strictBundleEntryPath
  <dd>
    On some operating systems Equinox may return a bundle entry that is requested with a path that does not
    correspond to an actual bundle entry path. For example, on Windows file name comparison operations are
    case insensitive. When this property is set to true, Equinox operates more strictly by checking that the
    requested bundle entry path exists. The default value is false for compatibility with the previous behaviour
    of Equinox. This property is relevant only when the bundle is installed from a folder (not jarred) and is
    ignored otherwise.
  </dd>
  <a name="osgisupportmultipleHosts"></a>osgi.support.multipleHosts <span style="font-style: italic;">NEW</span>
  <dd>
    if set to <b>true</b> then the framework will attempt to attach a fragment to all available host
    bundles which satisfy the fragment bundle's Fragment-Host constraint.  The default value is <b>false</b>.
  </dd>
  <a name="osgisupportsignatureverify"></a>osgi.support.signature.verify
  <dd>This option has been deprecated.  Use <a href="#osgisignedcontentsupport">osgi.signedcontent.support</a> instead.
  </dd>
  <a name="osgisupportclasscertificate"></a>osgi.support.class.certificate
  <dd>
   if set to <b>true</b> then the certificates available from a signed bundle are used when defining the classes from
   the signed bundle.  The default value is <b>true</b>.
   This option only takes effect when <a href="#osgisignedcontentsupport">osgi.signedcontent.support</a> is set
   to <b>certificate</b>.
  </dd>
  <a name="osgisyspath"></a>osgi.syspath
  <dd>set to the path where the eclipse OSGi Framework (org.eclipse.osgi) implementation
  is located.  For example, &quot;<eclipse install path>/eclipse/plugins&quot;.
  This property is set when the Eclipse platform is started and is not intended by be
  set by the user.</dd>
  <a name="osgiuserarea"></a>osgi.user.area {-user}
  <dd>the location of the user area. The user area contains data (e.g., preferences)
    specific to the OS user and independent of any Eclipse install, configuration
    or instance. See the section on <a href="#locations">locations</a> for more
    details.</dd>
  <a name="osgiuserareadefault" id="osgiuserareadefault"></a>osgi.user.area.default
  <dd>the default location of the user area. The user area contains data (e.g.,
    preferences) specific to the OS user and independent of any Eclipse install,
    configuration
    or instance. This value (i.e., the default setting) is only used if no value
    for the osgi.user.area is set. See the section on <a href="#locations">locations</a> for
    more details.</dd>
  <a name="osgiws"></a>osgi.ws {-ws}
  <dd>the window system value. The value should be one of the Eclipse window
    system names known to Eclipse (e.g., win32, motif, ...).</dd>

## Environment Variables
<p>The following environment variables are used by the Eclipse runtime. They may have
  command line equivalents (see the <a href="#commandline">command line arguments</a>
  section). Users are free to use either command line or environment variables to specify
  a value.</p>
<dl>
  <a name="env.eclipsekeyring"></a>ECLIPSE_KEYRING
  <dd>Set to override the location of the default secure storage. See the
    <a href="#eclipsekeyring">-eclipse.keyring</a> command line option.</dd>

## Locations

<p>The Eclipse runtime defines a number of <i>locations</i> which give plug-in
  developers context for reading/storing data and Eclipse users a control over
  the scope of data sharing and visibility. Eclipse defines the following notions
  of location:</p>
<dl>
    User (-user) {<a href="#osgiuserarea">osgi.user.area</a>} [@none, @noDefault, @user.home, @user.dir,
      filepath, url]
  * User locations are specific to, go figure, users. Typically the user
      location is based on the value of the Java <code>user.home</code> system
      property but this can be overridden. Information such as user scoped preferences
      and login information may be found in the user location.</dd>
    Install (-install) {osgi.install.area} [@launcher.dir, @user.home, @user.dir, filepath,
      url]
  * An install location is where Eclipse itself is installed. In practice
      this location is the directory (typically &quot;eclipse&quot;) which is
      the parent of the eclipse.exe being run or the plugins directory containing the org.eclipse.equinox.launcher bundle. This location should
      be considered read-only to normal users as an install may be shared by
      many users. It is possible to set the install location and decouple eclipse.exe
      from the rest of Eclipse.</dd>
    Configuration (-configuration) {osgi.configuration.area} [@none, @noDefault,
      @user.home, @user.dir, filepath, url]
  * Configuration locations contain files which identify and manage the (sub)set
      of an install to run. As such, there may be many configurations per install.
      Installs may come with a default configuration area but typical startup
      scenarios involve the runtime attempting to find a more writable configuration
      location. </dd>
    Instance (-data) {osgi.instance.area} [@none, @noDefault, @user.home,
      @user.dir, filepath, url]
  * Instance locations contain user-defined data artifacts. For example,
      the Resources plug-in uses the instance area as the workspace location
      and thus the default home for projects. Other plugins are free to write
      whatever files they like in this location.</dd>
</dl>
<p>While users can set any of these locations, Eclipse will compute reasonable
  defaults if values are not given. The most common usecase for setting location
  is the instance area or, in the IDE context, the workspace. To run the default
  Eclipse configuration on a specific data set you can specify:</p>
<pre>    eclipse -data c:\mydata</pre>
<h3>More Details</h3>
<p>Locations are URLs. For simplicity, file paths are also accepted and automatically
  converted to file: URLs. For better control and convenience, there are also
  a number of predefined symbolic locations which can be used. Note that not
  all combinations of location type and symbolic value are valid. A table below
  details which combinations are possible. Since the default case is for all
  locations to be set, valid and writable, some plug-ins may fail in other setups
  even if they are listed as possible. For example, it is unreasonable to expect
  a plug-in focused on user data (e.g., the Eclipse Resources plug-in) to do much
  if the instance area is not defined. It is up to plug-in developers to choose
  the setups they support and design their functionality accordingly.</p>
<dl>
    @none
  * Indicates that the corresponding location should never be set either
      explicitly or to its default value. For example, an RCP style application
      which has no user data may use osgi.instance.area=@none to prevent
      extraneous files being written to disk. @none must not be followed by any
      additional path segments.</dd>
    @noDefault
  * Forces a location to be undefined or explicitly defined (i.e., Eclipse
      will not automatically compute a default value). This is useful where you
      want to allow for data in the corresponding location but the Eclipse default
      value is not appropriate. @noDefault must not be followed by any
      additional path segments.</dd>
    @launcher.dir
  * Directs Eclipse to compute a location value relative to the directory
      containing the Eclipse launcher binary. @launcher.dir can be followed
      by additional path segments. In all cases, the string &quot;@location.dir&quot; is
      simply replaced with the parent directory of the path pointed to by the Java
      &quot;eclipse.launcher&quot; System property. For example, setting<br>
      &nbsp;&nbsp;&nbsp;&nbsp;osgi.install.area=@launcher.dir/../../../pool<br>
      results in a value of
      <br>
      &nbsp;&nbsp;&nbsp;&nbsp;file:/home/bob/eclipse-product/linux/gtk/x86_64/../../../pool<br>
      if the &quot;eclipse.launcher&quot; property is set to
      &quot;/home/bob/eclipse-product/linux/gtk/x86_64/eclipse&quot;.</dd>
    @user.home
  * Directs Eclipse to compute a location value relative to the user's home
      directory. @user.home can be followed
      by additional path segments. In all cases, the string &quot;@user.home&quot; is
      simply replaced with the value of the Java &quot;user.home&quot; System
      property. For example, setting<br>
      &nbsp;&nbsp;&nbsp;&nbsp;osgi.instance.area=@user.home/myWorkspace<br>
      results in a value of
      <br>
      &nbsp;&nbsp;&nbsp;&nbsp;file:/users/bob/myWorkspace</dd>
    @user.dir
  * Directs Eclipse to compute a location value relative to the current working
      directory. @user.dir can be followed
      by additional path segments. In all cases, the string &quot;@user.dir&quot; is
      simply replaced with the value of the Java &quot;user.dir&quot; System
      property. For example, setting<br>
&nbsp;&nbsp;&nbsp;&nbsp;osgi.instance.area=@user.dir/myWorkspace<br>
results in a value of <br>
&nbsp;&nbsp;&nbsp;&nbsp;file:/usr/share/eclipse/myWorkspace</dd>
</dl>
<table width="100%" border="0" bgcolor="#FFFFFF">
  <tr bgcolor="#CCCCCC">
    <td width="9%">location/value</td>
    <td width="13%"><div align="center">supports default</div></td>
    <td width="13%"><div align="center">file/URL</div>
    </td>
    <td width="13%"><div align="center">@none</div>
    </td>
    <td width="13%"><div align="center">@noDefault</div>
    </td>
    <td width="13%"><div align="center">@launcher.dir</div>
    </td>
    <td width="13%"><div align="center">@user.home</div>
    </td>
    <td width="13%"><div align="center">@user.dir</div>
    </td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC"><div align="center">instance</div>
    </td>
    <td><div align="center">yes</div></td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">no</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes (default)</div>
    </td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC"><div align="center">configuration</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes*</div>
    </td>
    <td><div align="center">yes*</div>
    </td>
    <td><div align="center">no</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes</div>
    </td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC"><div align="center">install</div>
    </td>
    <td><div align="center">no</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">no</div>
    </td>
    <td><div align="center">no</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes</div>
    </td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC"><div align="center">user</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">no</div>
    </td>
    <td><div align="center">yes</div>
    </td>
    <td><div align="center">yes</div>
    </td>
  </tr>
</table>
<p>* indicates that this setup is technically possible but pragmatically quite
  difficult to manage. In particular, without a configuration location the Eclipse
  runtime may only get as far as starting the OSGi framework.</p>

<h3>Read-only Locations</h3>

<p>
A location may be specified as a read-only location by appending &quot;.readOnly&quot;
to the location property and setting it to the value &quot;true&quot;.  The following properties
can be used to specify their corresponding locations as read-only:</p>
    <ul type="disc">
      <li>
          osgi.configuration.area.readOnly <a href="#osgiconfigurationarea">osgi.configuration.area</a>
      </li>
      <li>
          osgi.sharedConfiguration.area.readOnly <a href="#osgisharedconfigurationarea">osgi.sharedConfiguration.area</a>
      </li>
      <li>
          osgi.instance.area.readOnly <a href="#osgiinstancearea">osgi.instance.area</a>
      </li>
      <li>
          osgi.user.area.readOnly <a href="#osgiuserarea">osgi.user.area</a>
      </li>

## Variable Substitution | config.ini
<p>
The config.ini file located in the configuration area can be used to define configuration property values.
This file is a simple properties file with key=value pairs.  The values contained in the config.ini file may
optionally contain variables that can be substituted with the values of either system properties or environment
properties.  A variable which is to be substituted in the configuration value is surrounded by '$' characters.
For example, the following uses a windows environment variable LOCALAPPDATA to configure the instance area location:
</p>
<pre>    osgi.instance.area.default=$LOCALAPPDATA$/eclipse/workspace</pre>

## Launcher ini File
<p>
The eclipse.exe and more generally executables for RCP applications now read their parameters from an associated
ini file. This file offers a platform independent way to pass in arguments that previously had to be specified directly on
the command line such as vm or vm arguments. Although all parameters can be specified in this file, it recommend for maintainability
and consistency across various installations to only specify the vm location and the vm arguments in this ini file and use the config.ini
file for others.</p>

<h3>File Format</h3>
<p>This file must be named after the executable name (for example, eclipse.exe will read eclipse.ini, whereas launcher.exe will read launcher.ini) and every parameter
must be specified on a new line in the file. Here is an example of such a file specifying the vm location and some parameters:</p>
<pre>-vm
c:/myVm/java.exe
-vmargs
-Dms40M
</pre>
</body>
</html>
