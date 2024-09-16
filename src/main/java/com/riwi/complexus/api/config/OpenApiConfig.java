package com.riwi.complexus.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Complexus",
        version = "1.0",
        description = "This is the api of Complexus"
))
public class OpenApiConfig {
}
