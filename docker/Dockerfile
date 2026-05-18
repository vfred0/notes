FROM gradle:8.14.3-jdk21-ubi-minimal as builder

COPY --chown=gradle:gradle build.gradle /app/
COPY --chown=gradle:gradle settings.gradle /app/
COPY --chown=gradle:gradle src /app/src
WORKDIR /app

RUN --mount=type=cache,target=~/.gradle gradle clean bootJar --no-daemon --stacktrace

FROM eclipse-temurin:21.0.7_6-jre-ubi9-minimal AS runner

COPY --from=builder /app/build/libs/*.jar /app/app.jar
WORKDIR /app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]