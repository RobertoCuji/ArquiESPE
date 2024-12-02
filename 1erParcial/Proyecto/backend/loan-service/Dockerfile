FROM openjdk:21-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo .jar generado por Maven al contenedor
COPY target/loan-service-*.jar loan-service.jar

# Exponer el puerto en el que el servicio estará disponible
EXPOSE 8083

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "loan-service.jar"]
