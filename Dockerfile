FROM gradle:jdk17-alpine as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM eclipse-temurin:17-jre-alpine
EXPOSE 8080

WORKDIR /app

COPY --from=build /home/gradle/src/build/libs/*-all.jar /app/alticci.jar

EXPOSE 8080

ENTRYPOINT exec java -jar /app/alticci.jar