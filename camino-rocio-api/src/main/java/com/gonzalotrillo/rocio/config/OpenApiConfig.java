package com.gonzalotrillo.rocio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Camino al Rocío API")
                        .description("API REST con información sobre la Romería de El Rocío: hermandades, paradas del camino y fechas.")
                        .version("v0.1")
                        .contact(new Contact()
                                .name("Gonzalo Trillo Hidalgo")
                                .email("gonzalotrillohidalgo@gmail.com")));
    }
}
