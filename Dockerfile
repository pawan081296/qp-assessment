FROM openjdk:17-alpine
LABEL authors="Pawan"
COPY target/assesment-0.0.1-SNAPSHOT.jar qp-assesment-1.0.0.jar
ENTRYPOINT ["java","-jar","/qp-assesment-1.0.0.jar"]
