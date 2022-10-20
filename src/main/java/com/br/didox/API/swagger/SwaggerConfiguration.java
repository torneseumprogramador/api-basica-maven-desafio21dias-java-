package com.br.didox.API.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String EMAIL = "danilo@torneseumprogramador.com.br";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(apis())
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo());
    }
    
    private Predicate<RequestHandler> apis() {
        return RequestHandlerSelectors.basePackage("com.br.didox.API.controllers");
    }
    
    private ApiInfo apiInfo() {
   	 
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title ("Java API Desafio 21 dias")
                .contact(EMAIL)
                .description ("Documentação da API criada com alunos da comunidade do torne-se um programador no desafio 21 dias de java.")
                .version("1.0.0")
                .build();
 
        return apiInfo;
    }
}