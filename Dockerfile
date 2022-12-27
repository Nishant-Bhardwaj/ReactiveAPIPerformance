FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]


## COPY ${JAR_FILE} app.jar
 ## ${JAR_FILE} => our application jar copy to "app.jar"
 ## => app.jar is the target jar file deployed in docker