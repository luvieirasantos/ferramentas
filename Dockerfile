# Etapa de build (Maven + JDK 17)
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn -DskipTests=true clean package

# Etapa de runtime (JRE 17)
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENV JAVA_OPTS=""
EXPOSE 8080
CMD ["sh","-c","java $JAVA_OPTS -jar app.jar"]