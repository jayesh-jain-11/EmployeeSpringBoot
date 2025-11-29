# ---- Runtime Image ----
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy JAR from CI pipeline (target/*.jar will already exist)
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

