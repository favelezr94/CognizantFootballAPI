FROM openjdk:11
EXPOSE 8090
ADD target/football-team-management-service.jar football-team-management-service.jar
ENTRYPOINT ["java","-jar","/football-team-management-service.jar"]