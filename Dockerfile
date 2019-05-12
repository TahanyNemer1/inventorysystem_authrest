# Pull base image.
FROM gradle:5.4.0-jdk8 AS builder

ENV GRADLE_USER_HOME=/home/gradle/src
WORKDIR /home/gradle/src

COPY . .

USER root
RUN chown -R gradle /home/gradle/src
USER gradle

RUN gradle jar


FROM openjdk:8u212-jdk-stretch

WORKDIR /opt/app
COPY --from=builder /home/gradle/src/build/libs/*.jar .
# /home/gradle/src/server/build/libs/*.jar .

VOLUME /opt/app/db
EXPOSE 8080

CMD java -jar *.jar