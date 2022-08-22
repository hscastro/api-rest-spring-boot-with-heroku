package com.hscastro.rest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info =
@Info(title = "Person Service API",
    version = "v1",
    description = "Documention of Person Service API"))
public class OpenapiConfiguration {

    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(
                    new io.swagger.v3.oas.models.info.Info()
                        .title("Person Service API")
                        .version("v1")
                        .license(
                                new License()
                                    .name("apache 2.0")
                                    .url("httpp://springdoc.org")
                        )
                );
    }
}
