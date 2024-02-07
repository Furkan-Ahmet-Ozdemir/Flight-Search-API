package com.example.flightsearchapi.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

@Configuration
public class SwaggerConfig {
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Flight Search API")
                .version("1.0.0")
                .description("Case Study")
                .contact(new Contact("Furkan", "Contact_URL","furkan844.faz@gmail.com"))
                .build();
    }

}
