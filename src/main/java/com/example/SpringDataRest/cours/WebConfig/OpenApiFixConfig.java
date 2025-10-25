package com.example.SpringDataRest.cours.WebConfig;

import org.springdoc.core.configuration.SpringDocConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class OpenApiFixConfig {

    @Bean
    @Primary
    public SpringDocConfiguration springDocConfiguration() {
        return new SpringDocConfiguration() {

            public boolean isSpringDataRestAvailable() {
                return false;
            }
        };
    }
}