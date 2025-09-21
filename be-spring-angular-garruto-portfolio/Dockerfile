# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x ./mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src src

# Build the application (compile and create jar manually)
RUN ./mvnw clean compile
RUN ./mvnw package -DskipTests -Dmaven.test.skip=true

# Find and copy the jar file
RUN find target -name "*.jar" -exec cp {} app.jar \;

# Expose port
EXPOSE $PORT

# Run the application with production profile
CMD ["java", "-Dspring.profiles.active=prod", "-Dserver.port=${PORT}", "-jar", "app.jar"]