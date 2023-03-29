FROM openjdk:11
EXPOSE 8080
ADD target/account-management.jar account-management.jar
ENTRYPOINT ["java", "-jar", "/account-management.jar"]