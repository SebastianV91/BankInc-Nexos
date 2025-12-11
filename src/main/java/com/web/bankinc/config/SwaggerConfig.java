package com.web.bankinc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI cardModuleOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Card Module API")
                        .description("Documentación OpenAPI para el módulo Card del backend financiero")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Sebastián Vergara")
                                .email("sverter91@gmail.com")));
    }

}
