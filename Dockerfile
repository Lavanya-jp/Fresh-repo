# Use a base image with a Java Development Kit
FROM openjdk:11-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Java application code into the container
COPY Main.java .

# Compile the Java code
RUN javac Main.java

# Expose port 8080
EXPOSE 8080

# Command to run the application
CMD ["java", "Main"]
