FROM openjdk:11.0.14.1-jdk-slim-bullseye AS build-env
WORKDIR /app/
COPY ./mvnw .
COPY ./.mvn/ ./.mvn/
COPY ./pom.xml .
RUN ./mvnw verify clean --fail-never
COPY ./src/ ./src/
RUN ./mvnw package -DskipTests

FROM openjdk:11.0.14.1-jre-slim-bullseye
WORKDIR /app/
COPY --from=build-env /app/target/backend-*.jar .
CMD java -jar backend-*.jar
