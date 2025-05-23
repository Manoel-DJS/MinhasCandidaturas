package com.tec.api_candidatura.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Swagger {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("API_Candidatura")
                .displayName("Candidatura API")
                .pathsToMatch("/**")
                .build();
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("API_Candidatura")
                        .description("API REST para Gerenciar as Minhas Candidaturas.")
                        .version("v0.0.1")
                        .contact(new Contact()
                                .name("@Manoel")
                                .email("vinesouza9x9@gmail.com")
                        )
                        .license(new License()
                                .name("MIT LICENSE")
                                .url("https://github.com/Manoel-DJS")))
                .components(
                        new Components().addSecuritySchemes("Bearer", new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                .scheme("Bearer")
                                .bearerFormat("JWT")))
                .security(List.of(new SecurityRequirement().addList("Bearer")))
                .externalDocs(new ExternalDocumentation());

    }
}