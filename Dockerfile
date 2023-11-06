# Use an official Java runtime as the base image
FROM jelastic/maven:3.9.5-openjdk-22.ea-b21

# Set the working directory in the container
WORKDIR /app

COPY pom.xml .

# Copy the JAR file and the settings file to the container
COPY target/poker-0.0.1-SNAPSHOT.jar app.jar
COPY src/ src/

# Build the application using Maven
RUN mvn clean package

# Run the application
CMD ["java", "-jar", "app.jar"]