FROM eclipse-temurin:17-jdk-alpine AS BUILD_IMAGE
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY . $APP_HOME
RUN ls
RUN chmod +x gradlew
RUN ./gradlew build --no-daemon --stacktrace

FROM eclipse-temurin:17-jre-alpine
EXPOSE 8080
WORKDIR /app
COPY --from=BUILD_IMAGE /build/libs/*-all.jar /app/alticci.jar
EXPOSE 8080
ENTRYPOINT exec java -jar /app/alticci.jar