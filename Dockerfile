# ===============================
#        BUILD STAGE
# ===============================
FROM maven:3.8.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven wrapper and config first (better layer caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make wrapper executable
RUN chmod +x mvnw

# Download dependencies (cached if pom.xml unchanged)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests


# ===============================
#        RUNTIME STAGE
# ===============================
FROM eclipse-temurin:17-jre-jammy

# Create non-root user (security best practice)
RUN useradd -m springuser

WORKDIR /app

# Copy built JAR dynamically (no hardcoded name)
COPY --from=build /app/target/*.jar app.jar

# Set ownership
RUN chown -R springuser:springuser /app

USER springuser

# Application runs on 8085
EXPOSE 8085

# Memory tuning (can be overridden at runtime)
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Start application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
