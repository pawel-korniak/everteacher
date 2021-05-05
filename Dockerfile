# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY . /app
RUN ls app
#COPY src /home/app/src
#COPY pom.xml /home/app
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /app/target/everteacher-0.0.1.jar /app/target/everteacher-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/target/everteacher-0.0.1.jar"]

#ENTRYPOINT ["java","-jar","target/everteacher-0.0.1.jar"]
