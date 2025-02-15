* Project Description File -- `.project` --
  * 💡if a project is created | workspace -> project description file is AUTOMATICALLY generated 💡
  * describes the project
  * 's goal
    * make the project self-describing / project -- can be correctly -- recreated | ANOTHER workspace
  * located | direct member of the project's content area
  * 's name -- is exposed through the -- `org.eclipse.core.resources.IProjectDescription.DESCRIPTION_FILE_NAME` == `.project`
  * 👀's name, location, & content == workspace API 👀
    * == NO break EXISTING users of the file
  * recommendations
    * 💡NOT modify / delete / replace it 💡
      * Reason: 🧠 if it's invalid -> 
        * unusable project 🧠
        * project IMPOSSIBLE to open it
        * workspace does NOT generally attempt to repair it
  * modify it MANUALLY == `IProject.setDescription()`
  * 👀if a NEW project is created | location / ALREADY EXIST a project description file -> that one is reused 👀

# Configuration Markup

* 
    ```
    <projectDescription>
      <name>
      <comment>
      <projects>
      <buildSpec>  
      <natures>
      <linkedResources>
    ```
  * `name`
    * name of the project
    * ⚠️if != name of the project -> SOME elements below could be ignored ⚠️
    * == `IProjectDescription.getName()`
* `<comment>`
  * `comment`
    * comment for the project / arbitrary contents 
      * Reason: 🧠 NOT interpreted -- by the -- project or workspace 🧠
    * == `IProjectDescription.getComment()`
* 
  ```
  <projects>
    <project>
  ```
  * `projects`
    * == names of the projects / -- referenced by -- this project
    * == `IProjectDescription.getReferencedProjects()`
    * use cases
      * build dependencies
      * classpath resolution
      * resource sharing
* 
  ```
  <buildSpec>
    <buildCommand>
      <name>
      <arguments>
        <dictionary>
          <key>
          <value>
  ```
  * `buildSpec`
    * == ordered list of `buildCommand`
    * == `IProjectDescription.getBuildSpec()`
  * `buildCommand`
    * == 1! build commands
    * == `org.eclipse.core.resources.ICommand`
  * `name`
    * the symbolic name of an incremental project builder.&nbsp;
    * == `ICommand.getBuilderName()`
  * `arguments`
    * OPTIONAL arguments / -- may be passed to the -- project builder
    * == `ICommand.getArguments()`
  * `dictionary`
    * == list `(key, value)` == `java.util.Map`
* 
  ```
  <natures> 
    <nature>
  ```
  * `natures`
    * == names of the natures | this project
    * == `IProjectDescription.getNatureIds()`
  * `nature`
    * == name of 1! nature | this project
* 
  ```
  <linkedResources>
    <link>
      <name>
      <type>
      <location>
  ```
  * `linkedResources`
    * == list of project's linked resources
  * `link`
    * == definition of 1! linked resource
  * `name`
    * linked resource's project-relative path | workspace
  * `type`
    * == resource type
    * ALLOWED values
      * if it's a file -> `1`
      * if it's a folder -> `2`
  * `location`
    * target of the linked resource's local file system path
    * ALLOWED values
      * absolute path, or
      * relative path / first segment == name of a workspace
path variable
  * `locationURI`
    * if the file != | local file system -> absolute URI | SOME backing file system

# Example

```
<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
    <name>WinterProject</name>
    <comment>This is a cool project.</comment>
    <projects>
        <project>org.seasons.sdt</project>
        <project>CoolStuff</project>
    </projects>
    <buildSpec>
        <buildCommand>
            <name>org.seasons.sdt.seasonBuilder</name>
            <arguments>
                <dictionary>
                    <key>climate</key>
                    <value>cold</value>
                </dictionary>
            </arguments>
        </buildCommand>
    </buildSpec>
    <natures>
        <nature>org.seasons.sdt.seasonNature</nature>
    </natures>
</projectDescription>
```

# API Information
* == `org.eclipse.core.resources.IProjectDescription`
* if you want to override it -> use `IProject.setDescription()`
