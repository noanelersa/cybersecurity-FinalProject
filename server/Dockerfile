FROM openjdk:17-jdk-slim

COPY build/resources/main/application.properties application.properties
COPY build/libs/server-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]