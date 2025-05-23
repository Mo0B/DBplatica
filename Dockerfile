# Etapa 1: Construcción con Maven y JDK 21
FROM maven:3.9.0-jdk-21 AS build


WORKDIR /app

# Copiamos pom y código fuente
COPY pom.xml .
COPY src ./src

# Construimos el proyecto y empaquetamos el jar (sin tests para acelerar)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen más ligera con solo JRE para correr el jar
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el jar generado de la etapa build
COPY --from=build /app/target/DBPostgre-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto 8080 (puede variar si cambias en Spring)
EXPOSE 8080

# Usamos variable de entorno PORT para que Spring Boot escuche el puerto asignado
ENV PORT 8080

# Comando para ejecutar la app
ENTRYPOINT ["java","-jar","app.jar"]
