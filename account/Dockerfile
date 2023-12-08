FROM openjdk:21
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/account-app-service.jar
ADD ${JAR_FILE} account-app-service.jar
ENTRYPOINT ["java","-jar","/account-app-service.jar"]




