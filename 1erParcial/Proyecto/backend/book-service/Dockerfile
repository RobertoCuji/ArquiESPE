FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo .jar generado por Maven al contenedor
COPY target/book-service-*.jar book-service.jar

# Expone el puerto en el que el servicio estará disponible
EXPOSE 8082

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "book-service.jar"]
