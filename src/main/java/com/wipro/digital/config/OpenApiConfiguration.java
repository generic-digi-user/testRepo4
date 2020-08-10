package com.wipro.digital.config;

import com.google.common.base.Predicates;
import com.wipro.digital.config.AcceleratorConstants;
import com.wipro.digital.config.AcceleratorProperties;
import com.wipro.digital.config.apidoc.customizer.SwaggerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@Profile(AcceleratorConstants.SPRING_PROFILE_SWAGGER)
public class OpenApiConfiguration {

    @Bean
    public SwaggerCustomizer noApiFirstCustomizer() {
        return docket -> docket.select()
            .apis(Predicates.not(RequestHandlerSelectors.basePackage("com.wipro.digital.web.api")));
    }

    @Bean
    public Docket apiFirstDocket(AcceleratorProperties acceleratorProperties) {
        AcceleratorProperties.Swagger properties = acceleratorProperties.getSwagger();
        Contact contact = new Contact(
            properties.getContactName(),
            properties.getContactUrl(),
            properties.getContactEmail()
        );

        ApiInfo apiInfo = new ApiInfo(
            "API First " + properties.getTitle(),
            properties.getDescription(),
            properties.getVersion(),
            properties.getTermsOfServiceUrl(),
            contact,
            properties.getLicense(),
            properties.getLicenseUrl(),
            new ArrayList<>()
        );

        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("openapi")
            .host(properties.getHost())
            .protocols(new HashSet<>(Arrays.asList(properties.getProtocols())))
            .apiInfo(apiInfo)
            .useDefaultResponseMessages(properties.isUseDefaultResponseMessages())
            .forCodeGeneration(true)
            .directModelSubstitute(ByteBuffer.class, String.class)
            .genericModelSubstitutes(ResponseEntity.class)
            .ignoredParameterTypes(Pageable.class)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.wipro.digital.web.api"))
            .paths(regex(properties.getDefaultIncludePattern()))
            .build();
    }


}
