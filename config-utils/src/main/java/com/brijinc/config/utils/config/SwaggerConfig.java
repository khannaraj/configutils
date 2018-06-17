package com.brijinc.config.utils.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class sets the swagger information. It intialize teh swagger integration.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 */
@Configuration
@EnableSwagger2
// Loads the spring beans required by the framework
public class SwaggerConfig {

    @Bean
    public Docket servicesApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .paths(servicePaths())
                .build();
    }

    private Predicate<String> servicePaths() {
        return or(
                regex("/api/services.*"),
                regex("/api/data.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Application Configuration Utility")
                .description("This utility shows the configurations from various environments")
                .license("Apache License Version 2.0")
                .version("1.0")
                .build();
    }

}
