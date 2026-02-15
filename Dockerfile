# =========================
# Stage 1: Build with Maven
# =========================
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (for caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY src/ src/
COPY resources/ resources/
COPY test/ test/
COPY vars/ vars/

# Build the project
RUN mvn clean package -DskipTests

# =========================
# Stage 2: Create runtime image
# =========================
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy built jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Default command
CMD ["java", "-jar", "app.jar"]
