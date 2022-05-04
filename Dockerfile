FROM openjdk:8-jdk-alpine
COPY target/pfe-gitops-demo-*.jar pfe-gitops-demo.jar
ENTRYPOINT ["java","-jar", "pfe-gitops-demo.jar"]