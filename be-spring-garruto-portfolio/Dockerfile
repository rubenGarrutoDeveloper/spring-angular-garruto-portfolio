# Fase 1: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia il file jar generato da Maven nella cartella del container
# Il nome del file deriva da artifactId e versione nel pom.xml
COPY target/portfolio-backend-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta definita nelle tue properties
EXPOSE 8081

# Avvia l'applicazione con il profilo di produzione
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]