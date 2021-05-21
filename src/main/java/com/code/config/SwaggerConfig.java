package com.code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.code"))
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Reactive Mongo API",
                "Reactive mongo CRUD API using Spring Boot",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Tarvinder Singh", "https://github.com/Trickster689","tarvinder753@gmail.com"),
                "API license",
                "https://github.com/Trickster689",
                Collections.emptyList()
        );
    }
}
