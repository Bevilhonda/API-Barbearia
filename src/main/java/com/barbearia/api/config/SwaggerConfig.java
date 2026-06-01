package com.barbearia.api.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("API Barbearia")
                        .version("1.0")
                        .description("Sistema de agendamento para barbearia")
                        .contact(new Contact()
                                .name("Marcelo Bevilacqua de Andrade")
                        )
                );
    }
}