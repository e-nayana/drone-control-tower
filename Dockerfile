FROM maven:3.6.0-jdk-13 AS MAVEN_BUILD

MAINTAINER nayana

COPY ./ /usr/build/
WORKDIR /usr/build/
RUN mvn clean install


FROM openjdk:11-jdk

WORKDIR /usr/app

COPY --from=MAVEN_BUILD ./usr/build/target/musalasoft-drone-control-tower-0.0.1-SNAPSHOT.jar /usr/app/
ENTRYPOINT ["java","-jar","musalasoft-drone-control-tower-0.0.1-SNAPSHOT.jar"]
