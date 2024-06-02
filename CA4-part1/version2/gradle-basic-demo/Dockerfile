FROM gradle:jdk21

WORKDIR /CA4-part1-v2

COPY . /CA4-part1-v2

#RUN gradle clean build

ENTRYPOINT ["java", "-cp", "build/libs/basic_demo-0.1.0.jar", "basic_demo.ChatServerApp", "59001"]
