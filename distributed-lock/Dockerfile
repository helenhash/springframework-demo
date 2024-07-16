FROM maven:3.8-jdk-11-openj9 AS build
USER root
WORKDIR /app
COPY . .
RUN mvn clean package

FROM adoptopenjdk/openjdk11
USER root
WORKDIR /app
COPY --from=build /app/target/simple-demo-0.0.1-SNAPSHOT.jar ./simple-demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "simple-demo.jar"]



