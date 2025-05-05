package com.example.DBPostgre;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI Documentacion_api(){
        return new OpenAPI()
                .info(new Info()
                        .title("API de Control de entrada de Conjuntos Residenciales")
                        .version("1.0")
                        .description("Documentacion de API para el control de entrada de conjuntos residenciales")
                        .contact(new Contact()
                                .name("Mo0B")
                                .email("bachicanoy@ucundinamarca.edu.co")));
    }
}
