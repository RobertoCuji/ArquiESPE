package com.sivalabs.bookstore.gateway;

import jakarta.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Configuration;

@Configuration
class SwaggerConfig {
    private final RouteDefinitionLocator locator;
    private final SwaggerUiConfigProperties swaggerUiConfigProperties;

    public SwaggerConfig(RouteDefinitionLocator locator, SwaggerUiConfigProperties swaggerUiConfigProperties) {
        this.locator = locator;
        this.swaggerUiConfigProperties = swaggerUiConfigProperties;
    }

    @PostConstruct
    public void init() {
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls = new HashSet<>();
        definitions.stream()
                .filter(routeDefinition -> routeDefinition.getId().matches(".*-service")) // Filtra IDs con el patrón adecuado
                .forEach(routeDefinition -> {
                    String name = routeDefinition.getId().replaceAll("-service", ""); // Extrae el nombre del servicio
                    AbstractSwaggerUiConfigProperties.SwaggerUrl swaggerUrl = new AbstractSwaggerUiConfigProperties.SwaggerUrl(
                            name, "/api/" + name, null); // Ajusta la URL de Swagger
                    urls.add(swaggerUrl);
                });
        swaggerUiConfigProperties.setUrls(urls); // Configura las URLs de Swagger UI
    }
}
