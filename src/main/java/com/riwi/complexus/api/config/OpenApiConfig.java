package com.riwi.complexus.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Template",
        version = "1.0",
        description = "This is the api of Complexus"),
        servers = {
                @Server(url = "https://complexusproject-production-e80b.up.railway.app/swagger-ui/index.html", description = "Railway COMPLEXUS Server"),
                @Server(url = "http://localhost:8080/swagger-ui/index.html", description = "Local COMPLEXUS Server")
        }
)
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(
                        new Components().addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .name("Authorization")));
    }
}
