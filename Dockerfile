# ─── Stage 1: Build ────────────────────────────────────────────────────────────
# VULN: Using 'latest' tag instead of a pinned version (Checkov CKV_DOCKER_7)
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
# Download deps and package, skip tests for speed
RUN mvn package -DskipTests -q

# ─── Stage 2: Runtime ──────────────────────────────────────────────────────────
# VULN: Using 'latest' tag instead of pinned version (Checkov CKV_DOCKER_7)
FROM eclipse-temurin:21-jdk

# VULN: Running as root instead of a dedicated user (Checkov CKV_DOCKER_8)
USER root

# VULN: Missing HEALTHCHECK directive (Checkov CKV_DOCKER_2)

# VULN: Exposing SSH port unnecessarily (Checkov CKV_DOCKER_1)
EXPOSE 22
EXPOSE 8080

# VULN: Using ADD instead of COPY for local file (Checkov CKV_DOCKER_4)
ADD ./pom.xml /tmp/pom.xml

COPY --from=build /build/target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
