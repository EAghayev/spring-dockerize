FROM openjdk:21
VOLUME /tmp
EXPOSE 8080
ADD target/spring-rest.jar spring-basic.jar
ENTRYPOINT ["java","-jar","/spring-basic.jar"]