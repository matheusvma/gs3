package com.gs3.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Configura a documentação da API.
     * @return
     */
    @Bean
    public Docket apiConfigDocs() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gs3.app.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Informações da documentação.
     * @return informações da API
     */
    private ApiInfo infoDocs() {
        return new ApiInfo("Title - API Usuarios",
                "...",
                "1.0.0",
                "Terms",
                new Contact("Matheus Victor Marques Alves", "", "matheusmalves@yahoo.com.br"),
                "Apache License",
                "URL",
                new ArrayList<VendorExtension>());
    }

}
