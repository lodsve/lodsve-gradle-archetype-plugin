## gradle-archetype-plugin
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Flodsve%2Flodsve-gradle-archetype-plugin.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Flodsve%2Flodsve-gradle-archetype-plugin?ref=badge_shield)


Maven archetype like plugin for Gradle. Generating projects from local template.

源码构建使用 Gradle Wrapper 和 JDK 21；生成项目的 Java 版本由模板及目标应用自行决定。

### Install

https://plugins.gradle.org/plugin/com.lodsve.archetype

### Tasks

* `cleanArchetype`: cleans the generated folders and files.
* `generate`: generates projects from the template.

### Interactive Mode:

```
gradle cleanArch generate -i
```

### Batch Mode:

```
gradle cleanArch generate -i -Dtarget=generated -Dgroup=com.xxx.yyy -Dname=dummy-service -Dversion=1.0-SNAPSHOT
```

### Parameters

#### Prompted

Following parameters will be asked, if not available in system properties

| Param           | Description                                                | Default                        |
| --------------- | ---------------------------------------------------------- | ------------------------------ |
| group           | group name in Gradle or Maven, *Mandatory*                 |                                |
| name            | name in Gradle, of artifactId in Maven. *Mandatory*        |                                |
| packageName     | the package name , use '.' split folder name. *Mandatory*  |                                |
| version         | version in Gradle or Maven, *Mandatory*                    | 1.0-SNAPSHOT                   |
| author          | author, *Mandatory*                                        | Administrator                  |
| port            | service port, *Mandatory*                                  | 8080                           |
| contextPath     | service context path, *Mandatory*                          | /                              |
| configServerName| service config server name, *Mandatory*                    | config-server                  |
| configServerPort| service config server port, *Mandatory*                    | 8888                           |

#### Won't Be Prompted

Following parameters will NOT be prompted, if not available in system properties.

| Param           | Description                                         | Default                        |
| --------------- | ----------------------------------------------------| ------------------------------ |
| templates       | The folder path where template locates, *Mandatory* | `src/main/resources/templates` |
| failIfFileExist | Fail if there are files with the same name exist in the `generated` folder; otherwise overwrite | `true` |

#### System Properties

Parameters will firstly been searched in System Properties, which includes:

* gradle.properties: systemProp.param1=value1
* settings.properties: systemProp.param1=value1
* ~/.gradle/gradle.properties (not suggested for this plugin)
* Command line: -Dparam1=value1 -Dparam2=value2 -Dparam3=value3

### Variables:

Variables that can be used in template files.

| name               | description                                        | sample                |
| -------------------| -------------------------------------------------- | --------------------- |
| groupId            | project.group                                      | com.lodsve            |
| artifactId         | project.name                                       | service-demo          |
| packageName        | package name                                       | com.lodsve.demo       |
| packagePath        | package path                                       | com/lodsve/demo       |
| version            | project.version                                    | 1.0.0-SNAPSHOT        |
| author             | project.author                                     | Administrator         |
| port               | servicePort                                        | 8080                  |
| contextPath        | serviceContextPath                                 | /                     |

#### Adding Custom variables

Extra variables can be added via command line or programmatically with the
`com.lodsve.gradle.archetype.binding` prefix.

Command line :

```
-Dparam1=value1 -Dparam2=value2 -Dparam3=value3 ...
```

Property prefix :

```
System.setProperty('com.lodsve.gradle.archetype.binding.param1', value1)
```

#### Programmatic Customization of Bindings

Often, additional variables (bindings) need to be created based on the values of existing variables after they have been
resolved (e.g., when they are entered in interactive mode), but prior to the start of the actual generation process.

The `generate` task can be configured with a processor that is called just prior to the actual file generation, but
after all other variables have been resolved. The processor is just a closure that accepts a single argument, the
current binding configuration as a `Map`. The processor is specified by setting the `bindingProcessor` property of
the `generate` task.

For example:

```groovy
generate {
    bindingProcessor = { bindings ->
        bindings.capitalizedName = bindings.name.capitalize()
    }
}
```

### Token Format

* In code: `@variable@`
* In file name: `__variable__`

Additional GString expressions can be defined between the `@` and `__` tokens :

* `@variable.capitalize()@`
* `__new Date()__`

See [GStringTemplateEngine](http://docs.groovy-lang.org/latest/html/api/groovy/text/GStringTemplateEngine.html)

### Generated Project(s) Folder

Fixed to: `generated`.

### Non-templates:

Files that will not be resoled by variables, as they would fail if tried to resolve. Put the non-template lists
to `.nontemplates` file, and put the file to template folder (such as `src/main/resources/templates`)
or `src/main/resources/`.

Sample:

```
# comments
**/*.jar
**/*.bat
**/*.sh
**/*.zip
**/*.gz
**/*.xz
**/*.tar
**/*.7z

gradle/
.gradle/
gradlew
gradlew.bat
```

It follows ant style. The tailing slash for directory is mandatory.

### Known Issues

* Doesn't work with property files that have such escapes: key=https`\`://aaa.bbb.ccc/xxx, remove the `\` escape to have
  it work.
* In interactive mode, the prompt text got truncated sometimes.

## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Flodsve%2Flodsve-gradle-archetype-plugin.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Flodsve%2Flodsve-gradle-archetype-plugin?ref=badge_large)
