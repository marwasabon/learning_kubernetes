# Use lightweight Java runtime
FROM eclipse-temurin:17-jre
# Set working directory
WORKDIR /app

# Copy the JAR
COPY target/*.jar app.jar

# Expose application port
EXPOSE 8030

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
