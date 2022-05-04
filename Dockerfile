FROM openjdk:8-jdk-alpine
ADD target/pfe-gitops-demo-*.jar pfe-gitops-demo.jar
ENTRYPOINT ["java","-jar", "pfe-gitops-demo.jar"]