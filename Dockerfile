FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG DEPENDENCY=target/store-0.0.1-SNAPSHOT.jar

COPY ./target/store-0.0.1-SNAPSHOT.jar usr/app
WORKDIR usr/app
RUN sh -c 'touch store-0.0.1-SNAPSHOT.jar'



ENTRYPOINT ["java","-jar","store-0.0.1-SNAPSHOT.jar"]