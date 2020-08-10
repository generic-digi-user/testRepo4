# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="alok.srivastava@wipro.com"

# Add a volume pointing to /tmp
VOLUME /tmp
 

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE}  app1.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app1.jar"]