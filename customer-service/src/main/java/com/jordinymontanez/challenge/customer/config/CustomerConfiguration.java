package com.jordinymontanez.challenge.customer.config;

import com.jordinymontanez.challenge.customer.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class CustomerConfiguration {

    private static PropertiesConfig propertiesConfig;



    @Autowired
    public CustomerConfiguration(PropertiesConfig propertiesConfig) {
        CustomerConfiguration.propertiesConfig = propertiesConfig;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(propertiesConfig.getConfigValue(Constants.SwaggerType.TITLE.getValue()))
                .description(propertiesConfig.getConfigValue(Constants.SwaggerType.DESCRIPTION.getValue())).termsOfServiceUrl("")
                .contact(new Contact(
                        Constants.SwaggerType.CONTACT_NAME.getValue(),
                        Constants.SwaggerType.CONTACT_URL.getValue(),
                        Constants.SwaggerType.CONTACT_EMAIL.getValue()))
                .version(Constants.SwaggerType.VERSION.getValue())
                .build();
    }
}
