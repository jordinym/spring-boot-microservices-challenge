package com.jordinymontanez.challenge.customer.config;

import com.jordinymontanez.challenge.customer.common.Constants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@OpenAPIDefinition(info =
@io.swagger.v3.oas.annotations.info.Info(
        title = "Customer Service - REST APIs",
        version = "1.0",
        description = "Challenge - Microservices With Spring Boot starter",
        contact = @io.swagger.v3.oas.annotations.info.Contact(name ="Jordiny Montañez" ,email ="jordinym@gmail.com" ,url ="https://www.linkedin.com/in/jordinymontanez" )
)
)
public class CustomerConfiguration {

    private static PropertiesConfig propertiesConfig;
    @Autowired
    public CustomerConfiguration(PropertiesConfig propertiesConfig) {
        CustomerConfiguration.propertiesConfig = propertiesConfig;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer () {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo(appVersion));
    }

    private Contact getSwaggerContact(){
            return new Contact()
            .email(Constants.SwaggerType.CONTACT_EMAIL.getValue())
            .url(Constants.SwaggerType.CONTACT_URL.getValue())
            .name(Constants.SwaggerType.CONTACT_NAME.getValue());
    }
    private License getSwaggerLicense(){
        return new License()
                .name("Apache 2.0")
                .url("http://springdoc.org");
    }
    private Info apiInfo(String appVersion) {
        return new Info()
                .title(propertiesConfig.getConfigValue(Constants.SwaggerType.TITLE.getValue()))
                .description(propertiesConfig.getConfigValue(Constants.SwaggerType.DESCRIPTION.getValue()))
                .contact(getSwaggerContact())
                .version(Constants.SwaggerType.VERSION.getValue())
                .license(getSwaggerLicense());
    }
}
