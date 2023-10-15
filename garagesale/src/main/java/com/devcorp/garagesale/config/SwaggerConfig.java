package com.devcorp.garagesale.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("api-docs")
                .packagesToScan("com.devcorp.garagesale.controller")
                .pathsToMatch("/api/SellerController")
                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Name REST API")
                        .description("\"Name REST API\"")
                        .version("3.0"));
    }
}

