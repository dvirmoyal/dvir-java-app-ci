
FROM maven:3.9.5-eclipse-temurin-17 AS builder
WORKDIR /app


COPY pom.xml ./
RUN mvn dependency:go-offline


COPY src ./src
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jdk
WORKDIR /app


COPY --from=builder /app/target/dvir-java-app-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8081


ENTRYPOINT ["java", "-jar", "app.jar"]
