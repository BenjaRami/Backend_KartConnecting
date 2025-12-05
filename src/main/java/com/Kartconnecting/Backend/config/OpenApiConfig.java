package com.Kartconnecting.Backend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Kartconnecting API")
                        .version("v1")
                        .description("API del backend para Kartconnecting"))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio")
                        .url("https://github.com/BenjaRami/Backend_KartConnecting"));
    }

}
