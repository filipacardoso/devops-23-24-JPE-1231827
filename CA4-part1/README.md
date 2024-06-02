# Class Assignment 4 - Part 1: Containers with Docker


## Introduction
The goal of this assignment is to explore Docker's capabilities by creating and running 
Docker containers and images. Using a chat application,  two 
methods were used to build Docker images: one where the chat server is built
within the Docker image, and a second one where the chat server is built on the host
machine and the resulting JAR file is copied into the Docker image. 

## Version 1 - Building the Docker Image for the Chat Server 

In this version, the chat server is built directly inside the Docker image, 
as shown in the Dockerfile below. 

```Dockerfile
FROM gradle:jdk21

WORKDIR /CA4-part1-v1

COPY . /CA4-part1-v1

RUN gradle clean build

ENTRYPOINT ["java", "-cp", "build/libs/basic_demo-0.1.0.jar", "basic_demo.ChatServerApp", "59001"]
```

This dockerfile creates a Docker image that:

- Uses a base image with Gradle and JDK 21.
- Sets the working directory to /CA4-part1-v1.
- Copies the application source code into the container.
- Builds the application using Gradle.
- Specifies an entry point to run the ChatServerApp Java application with the JAR file located in build/libs and port 59001.

To build the Docker image, the following command was used in the directory containing the 
Dockerfile and the application source code:

```bash
docker build -t -t chat-server:version1  .
```

To run the Docker container, the following command was used:

```bash
docker run -p 59001:59001 chat-server:version1
```

To start the chat client, the following command should be run in the host machine:

```bash
./gradlew runClient
```

## Version 2 - Building the Docker Image for the Chat Server

In this version, the chat server is built on the host machine, 
and the resulting JAR file is copied into the Docker image, as shown in the Dockerfile below.

```Dockerfile
FROM gradle:jdk21

WORKDIR /CA4-part1-v2

COPY . /CA4-part1-v2

ENTRYPOINT ["java", "-cp", "build/libs/basic_demo-0.1.0.jar", "basic_demo.ChatServerApp", "59001"]
```

This dockerfile creates a Docker image that:

- Uses a base image with Gradle and JDK 21.
- Sets the working directory to /CA4-part1-v2.
- Copies the application source code into the container.
- Specifies an entry point to run the ChatServerApp Java application with the JAR file located in build/libs and port 59001.

To build the Java project the following command was used:
```bash
./gradlew clean build
```

To build the Docker image, the following command was used in the directory containing the Dockerfile and the application source code:

```bash
docker build -t chat-server:version2 .
```

To run the Docker container, the following command was used:

```bash
docker run -p 59001:59001 chat-server:version2
```

To start the chat client, the following command should be run in the host machine:

```bash
./gradlew runClient
```


###Main Differences between the two Dockerfile versions:
The main difference between the first and the second Dockerfile is the
absence of the RUN gradle clean build command in the second Dockerfile, which means that:

- The second version of the Dockerfile does not build the application inside the Docker container.
- It assumes that the basic_demo-0.1.0.jar file already exists in the build/libs directory when the Docker image is built.

In summary, the second Dockerfile is used for running the application
without building it inside the Docker container, which implies that the JAR file
must be pre-built and present in the specified location before building the Docker image.







