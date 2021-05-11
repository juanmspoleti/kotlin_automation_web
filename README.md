#Kotlin Automation WEB project

## Installation
You need to have:

* [JDK 1.8](https://www.oracle.com/ar/java/technologies/javase/javase-jdk8-downloads.html) (to run Kotlin)
* [Maven](https://maven.apache.org/download.cgi) (if we want to run in console, instead of Intellij IDEA or Eclipse)
* Set JAVA_HOME and MAVEN_HOME environment variables.
* [Docker Compose](https://docs.docker.com/compose/install/) (if you want to run with Selenium Grid simulating a server environment)

## How it works
We have a BDD structure, so I recommend that see first the features file, then go step after step understand his behaviour.

## Run
### All testcases:
mvn clean test -Pprod

### Only search:
mvn clean test -Pprod "-Dcucumber.filter=-t @Search"

### Specific functionality:
mvn clean test "-Dcucumber.filter=-t @specific-tag"

#### Functionalities available:
@Search

### For debug:
We need to add -DforkCount=0 like this: <b>mvn clean test -DforkCount=0</b>

## Multi browsers
By default, the framework runs with Chrome, to run with Firefox add to the mvn command line: -Dbrowser=firefox For example: <b>mvn clean test -Dbrowser=firefox</b>

#### Browsers available:
* chrome 
* firefox

## Technologies used:
* [Kotlin](https://kotlinlang.org/)
* Maven
* Selenium
* TestNG (runner)
* Cucumber (BDD)
* Log4j (logger)
* [Bonigarcia](https://github.com/bonigarcia/webdrivermanager) (setup drivers automatically)
* This was made in [Intellij IDEA](https://www.jetbrains.com/idea/)

## Reports
* Run status report: once we run the test, is located in <b>target/report.json</b> This reporter shows the information of the tests:
    * Total test
    * Total pass
    * Total fail
    * Total skip
    * Total pending
    * Percentage pass
    * Percentage fail

## Project structure
* <i>src/test/resources/features</i> = features files with the scenarios, gherkin and data (BDD).
* <i>src/test/kotlin/**/Hooks</i> = hooks in general of cucumber for this project (before and after)
* <i>src/main/resources</i> = properties files: cucumber options, log4 and project configs (config.properties)
* <i>src/main/kotlin/**/steps</i> = steps that matches with gherkin from features files
* <i>src/main/kotlin/**/pages</i> = interactions with the pages of the application (Page factory pattern)
* <i>src/main/kotlin/**/core</i> = different implementations:
    * DriverService: manage the driver instance
    * Browser package: Different browser implementations (their capabilities, driver class, etc) and BrowserType enum with the different types of browser
    * PropertyManager: loads the properties (located in config.properties) and use them in the lifecycle
    * Report package: implementation of the status report with a manager, and a service