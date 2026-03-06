FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY target/OTP1_inclass_assignment-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]