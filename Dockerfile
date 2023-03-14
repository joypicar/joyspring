FROM openjdk:8-jre-alpine
ADD ./docker-spring-boot-0.0.1-SNAPSHOT.jar docker-spring-boot.jar
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]