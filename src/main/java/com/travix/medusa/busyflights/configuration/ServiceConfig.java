package com.travix.medusa.busyflights.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travix.medusa.busyflights.util.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Declare beans required by this api
 */
@Configuration
public class ServiceConfig {

    /**
     * Wire in the ObjectMapper from the JsonMapper utility class which
     * creates the ObjectMapper with the correct date time format settings.
     * <p>
     * Primary annotation means this will be the ObjectMapper used when autowiring (including internally by Spring MVC)
     *
     * @return ObjectMapper The object mapper used throughout the service and by Spring.
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return JsonMapper.getObjectMapper();
    }
}
