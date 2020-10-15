FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8080
ARG JAR_FILE=backend-211.0000.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]