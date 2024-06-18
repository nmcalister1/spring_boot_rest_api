FROM openjdk:17-jdk-alpine
MAINTAINER nmcalister.com
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]