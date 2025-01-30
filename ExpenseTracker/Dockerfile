
# Use OpenJDK 21 base image
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/ExpenseTracker-0.0.1-SNAPSHOT.jar auth-service.jar

# Expose the port your app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "auth-service.jar"]