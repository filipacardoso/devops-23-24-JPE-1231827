# Class Assignment 2, Part 1 : Build Tools with Gradle

## Introduction: What is Gradle?
Gradle is a tool for automating the building process of software projects, based on Apache Ant and Apache Maven but uses a Groovy-based language instead of Maven's XML format for project setup.
Gradle uses a directed acyclic graph ("DAG") to determine the order in which tasks can be run.
It's particularly useful for large projects, allowing incremental builds by identifying only the parts of the project that have changed since the last build. Plus, it can reuse outputs from previous builds to speed up the process.

### Assignment Overview
The aim of this assignment was to use a fundamental Gradle application to introduce new features. This exercise was designed to enhance comprehension of the Gradle functionality and to edit the
build.gradle file to incorporate additional tasks and dependencies.

## First Steps

1. Cloning the repository

To complete this assignment, the first step is to clone the repository from this [link](https://bitbucket.org/pssmatos/gradle_basic_demo/) to the local machine,
   as it will provide the basic structure of the project and the necessary files to work on.


2. In the DevOps private repository, a new directory was created to store the cloned repository.
```bash
mkdir CA2
cd CA2
mkdir part1
mkdir part2
```
After the directories creation, the repository was copied into the part1 directory.
```bash
cp -r /path/to/gradle_basic_demo/CA2/part1
```
3. Commit the changes to the DevOps repository.

After copying the repository, the changes were committed to the DevOps repository.
```bash
git add .
git commit -m "added folder CA2 and new README file, closes #7"
git push origin main
```
### Exploring the application
The application used for this assignment features a simple multithreaded chat room server capable of accommodating multiple 
clients concurrently. Upon connecting to the server, each client must select a unique screen name. Once acknowledged by the 
server, clients can begin exchanging messages within the chat room. The server then relays these messages to all connected 
clients, enabling group communication.

#### Prerequisites
- Java JDK 8 (or newer)
- Apache Log4J 2
- Gradle 7.4.1 (if you do not use the gradle wrapper in the project)

#### Build
To build a .jar file with the application the following command must be used:
```gradle
    % ./gradlew build
```

#### Run the server
To run the server, open a terminal and execute the following command from the project's root directory:

```gradle
    % java -cp build/libs/basic_demo-0.1.0.jar basic_demo.ChatServerApp <server port>
```
Substitute *server port* in the command by a valid por number, e.g. 59001.

#### Run a client
To run a client, open a terminal and execute the following command from the project's root directory:

```gradle
 % ./gradlew runClient
```

The instructions provided assume that the chat server's IP address is set to "localhost" and its port number is "59001". If different parameters are required, it is necessary to modify the "runClient" task within the "build.gradle" file.
To run multiple clients simultaneously, open additional terminals and repeat the invocation of the "runClient" task as needed. This allows for concurrent execution of multiple clients connecting to the chat server.

## Adding new tasks

In order to create and build the project using the newly implemented tasks, the build.gradle file was edited to include the new tasks
and dependencies. Also, the gradle wrapper version was updated to 8.6 in the gradle-wrapper.properties file.

### Task 1: Addition of a task to run the server

The first task created was to run the server. The task was named "runServer" and it was added to the build.gradle file as follows:

```groovy
task runServer(type:JavaExec, dependsOn: classes){
    group = "DevOps"
    description = "Launches a chat server that listens on port 59001"

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    args '59001'
}
```
This task is of type JavaExec, which means it will run a Java application. The task depends on the classes task, a lifecycle task added
by the Java plugin, which ensures that the classes are compiled before the server is run. The classpath is set to the runtime classpath,
which includes the compiled class files and the runtime dependencies. The main class is set to the ChatServerApp class, which specifies
the name of the Java class to be executed with the task, in this case, it's the ChatServerApp class in the basic_demo package.

In order to run the server and compile the project with the new task included, the project was built again.
```gradle
 % ./gradlew build
```
With the addition of the new runServer task, the newly added changes were committed and pushed to the remote repository.
```bash
git add .
git commit -m "closes #9 Added run server task. updated gradle version on gradle wrapper"
git push origin main
```

### Addition of test class and unit test
A new test class was added to the project with a unit test. The class *AppTest* was added to the
src/test/java/basic_demo package. In order to do so, the following commands were executed:
```bash
mkdir -p src/test/java/basic_demo
touch src/test/java/basic_demo/AppTest.java
```
To set up the test class and add the unit test, the following code was added to the AppTest.java file:
```java
package basic_demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
```
In order to run the unit test, the dependencies were updated in the build.gradle file to include the JUnit library.
```groovy
dependencies {
    // Use Apache Log4J for logging
    implementation group: 'org.apache.logging.log4j', name: 'log4j-api', version: '2.11.2'
    implementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.11.2'
    testImplementation group: 'junit', name: 'junit', version: '4.12'
}
```
After updating the dependencies, the project could be built again.
```gradle
 % ./gradlew build
```
With the new features implemented, the changes were committed and pushed to the remote repository.
```bash
git add .
git commit -m "closes #10 Added AppTest class"
git push origin main
``` 

### Task 2: Addition of a task to copy source files
The class assignment required the addition of a new task to copy the source files to a new directory named *backup*.
```groovy
task copySRCToBackup(type: Copy){
   group = "DevOps"
   description = "Copies the source code to a backup directory"
   from 'src/'
   into 'backup/'
}
```
This task, named "copySRCToBackup", is categorized under "DevOps" and is designed to copy the source code from the 'src/' directory to a backup directory named 'backup/'. It is a straightforward operation intended to ensure redundancy and backup of the source code, likely as a part of a larger development or deployment process.

In order to run the task to following command was used.
```gradle
 % ./gradlew copySRCToBackup
```
With the addition of the new copySRCToBackup task, the newly added changes were committed and pushed to the remote repository.
```bash
git add .
git commit -m "closes #11 Added Copy task to build.gradle file"
git push origin main
```
### Task 3: Addition of a task to zip source files
The class assignment required the addition of a new task to zip the source files.
```groovy
task zipSource(type:Zip){
   group = "DevOps"
   description = "Zip the source code"

   from '/src'
   archiveBaseName.set("source")
   archiveExtension.set("zip")
}
```
This task, named "zipSource," is categorized under "DevOps" and is aim eas to compress the source code located in the '/src' directory into a zip file. It sets the base name of the zip file as "source" and specifies the extension as ".zip". 

In order to run the task to following command was used.
```gradle
 % ./gradlew zipSource
```
With the addition of the new zipSource task, the newly added changes were committed and pushed to the remote repository.
```bash
git add .
git commit -m "closes #12 added task to zip source code"
git push origin main
```
Tag the new version of the application as `ca2-part1` and push the tag to the remote repository:
```bash
git tag ca2-part1 -m "Implemented Part 1 of Class Assignment 2"
git push origin ca2-part1
```

