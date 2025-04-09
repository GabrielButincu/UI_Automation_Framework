# MAGNETO UI - LUMA - Automation Framework
## _Setup, Install and Test Running Guide_

This document will provide you the necessary details to install the prerequisites, set up the project and run the tests.

### Pre-requisites
*Follow the steps in the links to download and install the following tools*

1. Intellij Idea Community Edition - [download latest version](https://www.jetbrains.com/idea/download/)
2. Open JDK 20 - [download](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
3. Add JDK to the JAVA_HOME and Path environment variables - [tutorial](https://mkyong.com/java/how-to-set-java_home-on-windows-10/)
4. Download and install Maven - [tutorial](https://phoenixnap.com/kb/install-maven-windows)

**Make sure that you have all the pre-requisites correctly installed before moving on to the next step!**

### Project Setup
Go to the folder where you want to save the repo, open cmd or powershell and **clone the project**
```sh
git clone htpp // NEED TO BE CHANGE
```

Open the project in Intellij Idea
- On the right in the Maven tab > Reload All Maven Projects
- In terminal execute ```mvn clean install```
- In File > Settings > Plugins > search for *Cucumber for Java* and install it


### Running the tests
##### Create a run configuration
1. In IntelliJ go to Run Configurations > Edit Configurations
2. Add New Configuration > JUnit
3. In the Build and Run category
    - select java 20/Open JDK 20
    - select *All in Directory* and ```C:\<path to your repo>\src\test\java\runner```

##### Configuring the tests
Running a specific test
- In ```src/test/java/runner/TestRunner.java``` file you can edit the ```tags``` property to include the tests you want to be run

Changing the test environment and browser
- In ```src/test/java/config/config.properties``` you can edit the following properties
    - ```browser``` -> changes the driver used for the test (e.g. chrome, edge)
    - ```url``` -> changes the root url of the application

##### Running the tests
Using the previously created run configuration **Run**(Shift+F10) the tests

##### Viewing a report
After a test run a Cucumber Report is automatically created in ```target/CucumberReports/CucumberReport.html```
The html report can be opened in any browser to see more details about the test run



***P.S.** If any information in this document is incorrect or outdated please contact the code owners to modify it or modify it yourself. Thank you!*