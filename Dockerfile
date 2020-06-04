FROM openjdk:8-jdk-alpine

VOLUME /tmp
EXPOSE 8080

ARG JAR_FILE=target/store-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} store-demo.jar

ENTRYPOINT ["java","-jar","/store-demo.jar"]

