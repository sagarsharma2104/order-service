FROM openjdk:8-jdk-alpine
MAINTAINER sagar.sharma01@nagarro.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} order_service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/order_service.jar"]