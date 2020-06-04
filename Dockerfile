FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG DEPENDENCY=target/store-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app
COPY ${DEPENDENCY} app.jar


ENTRYPOINT ["java","-jar","app.jar"]