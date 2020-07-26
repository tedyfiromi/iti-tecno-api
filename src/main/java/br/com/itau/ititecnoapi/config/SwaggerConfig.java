package br.com.itau.ititecnoapi.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.itau.ititecnoapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(infoApi().build());
    }

    private ApiInfoBuilder infoApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Iti Tecnology Api Test");
        apiInfoBuilder.description("This is a Api Test to Iti");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("All rights reserved to Itau");
        apiInfoBuilder.licenseUrl("http://www.itau.com.br");

        return apiInfoBuilder;

    }
}
