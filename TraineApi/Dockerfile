#FROM eclipse-temurin:22-jdk
#COPY target/springdemo-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM eclipse-temurin:22-jdk
WORKDIR /app
COPY target/springdemo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]