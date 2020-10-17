FROM debian:latest

RUN echo 'deb http://ftp.debian.org/debian stretch-backports main' | tee /etc/apt/sources.list.d/stretch-backports.list
RUN apt update
RUN apt install -y openjdk-11-jdk

ENV MYBUDGET_DB_URL ""
ENV MYBUDGET_DB_USERNAME ""
ENV MYBUDGET_DB_PASSWORD ""

EXPOSE 8080
ARG JAR_FILE=backend-211.0000.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]