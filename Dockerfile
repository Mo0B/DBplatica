# Etapa de build: Maven con Java 21
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar archivos del proyecto
COPY pom.xml .
COPY src ./src

# Construir el proyecto sin ejecutar tests
RUN mvn clean package -DskipTests

# Etapa final: solo el JRE para ejecutar el jar
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar el jar desde el contenedor de compilación
COPY --from=build /app/target/DBPostgre-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Permitir que Render asigne el puerto dinámicamente
ENV PORT 8080

# Ejecutar el jar
ENTRYPOINT ["java", "-jar", "app.jar"]
