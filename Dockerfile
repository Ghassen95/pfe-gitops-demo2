FROM openjdk:8-jdk-alpine
ADD target/Timesheet-devops-1.0.jar Timesheet-devops-1.0.jar
ENTRYPOINT ["java","-jar", "Timesheet-devops-1.0.jar"]