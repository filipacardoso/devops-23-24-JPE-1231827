# Class Assignment 4 - Part 2: Containers with Docker

## Introduction
The goal of this assignment is to explore the use of Docker to 
make containers of a web application and an H2 database. 
By leveraging Docker and Docker Compose, dependencies 
can be managed to ensure consistency across different
environments, and streamline the deployment process.

## Docker Compose
Docker Compose is a tool that allows multiple Docker containers
to be defined and run as a single service. It uses a YAML file
to configure the application. This simplifies the
process of managing multiple containers and their dependencies.

The docker-compose.yml file defines two services: a web application
and an H2 database, as shown below:

```yaml
services:
  db:
    build:
      context: .
      dockerfile: Dockerfile-db
    container_name: h2-db
    ports:
      - "8082:8082"
      - "9092:9092"
    volumes:
      - h2-data:/opt/h2-data

  web:
    build:
      context: .
      dockerfile: Dockerfile-web
    container_name: spring-web
    ports:
      - "8080:8080"
    depends_on:
      - db

volumes:
  h2-data:
    driver: local
```

The docker-compose.yml file sets up and orchestrates 
both services, ensuring that the database starts before
the web application. The "volumes" section of the file
is used to persist the data in the H2 database.

A dockerfile for the web application was created to build
the Docker image, as shown below:

```Dockerfile
FROM gradle:jdk21
WORKDIR /app
COPY . /app

RUN gradle clean build

ENTRYPOINT ["gradle"]
CMD ["bootRun"]
```

This dockerfile sets up the working directory, copies the
application source code, builds the application, and runs
the JAR file.
- `gradle:jdk21`:  Official Gradle image that includes Gradle and JDK 21. This ensures that Gradle and the Java Development Kit are available in the container.
- `WORKDIR /app`: This sets the working directory inside the container to /app.
  The subsequent commands (COPY and RUN) will be executed in this directory.
- `COPY . /app`: Copies all files from the current directory to `/app`.
- `RUN gradle clean build`: Removes any previous build outputs and compiles the source code, runs tests, and packages the application.
- `ENTRYPOINT ["gradle"]`: Sets the entry point for the Docker container to the gradle command,
which will be executed when the container starts.
- `CMD ["bootRun"]`: Starts the Spring Boot application



The Dockerfile for the H2 database is as follows:

```Dockerfile
FROM ubuntu:focal
RUN apt-get update && \
    apt-get install -y wget openjdk-17-jdk-headless && \
    rm -rf /var/lib/apt/lists/* \
WORKDIR /opt/h2
RUN wget https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar -O h2.jar
EXPOSE 8082
EXPOSE 9092
CMD ["java", "-cp", "h2.jar", "org.h2.tools.Server", "-ifNotExists", "-web", "-webAllowOthers", "-webPort", "8082", "-tcp", "-tcpAllowOthers", "-tcpPort", "9092"]
```

This Dockerfile sets up the H2 database container:
- `FROM ubuntu:focal`: Specifies the base image as Ubuntu Focal.
- `RUN apt-get update && ...`: Updates the package list, installs necessary packages, and cleans up.
- `WORKDIR /opt/h2`: Sets the working directory to /opt/h2.
- `RUN wget ... -O h2.jar`: Downloads the H2 database JAR file.
- `EXPOSE 8082`: Exposes port 8082 for the H2 web console.
- `EXPOSE 9092`: Exposes port 9092 for the H2 database TCP server.
- `CMD ["java", "-cp", "h2.jar", ...]`: Starts the H2 database server.

## Building and Running the Docker Containers

To build the Docker containers, the following command was used:

```bash
docker-compose up --build
```
To access the services running you may use:

Spring Boot Application: http://localhost:8080/basic-0.0.1-SNAPSHOT/

H2 Database Console: http://localhost:8082

In H2 Database Console, change url to: jdbc:h2:tcp://db:9092/./jpadb

To stop the services, we run the following command:

```bash
docker-compose down
```





