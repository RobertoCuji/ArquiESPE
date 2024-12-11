# Usa una imagen base de OpenJDK para Java
FROM openjdk:21-jdk-slim

# Configura un directorio de trabajo
WORKDIR /app

# Copia el archivo JAR del API Gateway al contenedor
COPY target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar

# Expone el puerto 8080 para el API Gateway
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "gateway.jar"]


# Usa la imagen base de Nginx
FROM nginx:latest

# Copia el archivo nginx.conf al contenedor
COPY nginx.conf /etc/nginx/nginx.conf

# Expone el puerto 8080
EXPOSE 8080
