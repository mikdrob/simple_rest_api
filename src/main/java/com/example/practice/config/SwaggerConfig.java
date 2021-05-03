package com.example.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Import(BeanValidatorPluginsConfiguration.class)
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    // swagger config, defines scope and paths
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.practice"))
                .build()
                .apiInfo(apiInfo());
    }

    // override of api info
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API",
                "Simple api to find a 'person' from database.",
                "1.0",
                "Terms of service",
                new Contact("Mikhail Drobyshev", "www.imaginaryCompany.com", "mgdrobyshev@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}
