# Use official OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Optional: build the project
RUN ./mvnw clean package

# Default command
CMD ["java", "-jar", "target/company-ci-library-1.0.0.jar"]
