FROM debian:bullseye-slim
RUN apt-get update && \
    apt-get install -y maven
 
WORKDIR /app
COPY . .

RUN mvn clean install
 
FROM openjdk:21
EXPOSE 8080
ADD target/accounts-0.0.1-SNAPSHOT.jar accounts-app-service.jar
ENTRYPOINT ["java", "-jar", "accounts-app-service.jar"]