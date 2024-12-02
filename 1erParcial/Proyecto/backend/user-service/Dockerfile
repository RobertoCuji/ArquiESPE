# Imagen base de Java 17
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo .jar generado por Maven al contenedor
COPY target/user-service-*.jar user-service.jar

# Exponer el puerto en el que el servicio estará disponible
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "user-service.jar"]
