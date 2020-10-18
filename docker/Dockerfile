FROM debian@sha256:8414aa82208bc4c2761dc149df67e25c6b8a9380e5d8c4e7b5c84ca2d04bb244

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