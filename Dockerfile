# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY . /
RUN mvn -f /pom.xml clean package -Dmaven.test.skip

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /course.txt /
COPY --from=build /target/everteacher-0.0.1.jar /target/everteacher-0.0.1.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/target/everteacher-0.0.1.jar"]

