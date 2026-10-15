# ─── Stage 2: Runtime ──────────────────────────────────────────────────────────
# VULN: Using 'latest' tag instead of pinned version (Checkov CKV_DOCKER_7)
FROM eclipse-temurin:21-jdk

# VULN: Exposing SSH port unnecessarily (Checkov CKV_DOCKER_1)
EXPOSE 22
EXPOSE 8080

# VULN: Using ADD instead of COPY for local file (Checkov CKV_DOCKER_4)
COPY ./pom.xml /tmp/pom.xml

COPY --from=build /build/target/*.jar /app/app.jar

RUN useradd -m -u 1000 appuser && chown -R appuser:appuser /app
USER appuser

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
