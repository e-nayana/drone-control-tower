package org.musalasoft.controlltower.config;

import org.modelmapper.ModelMapper;
import org.musalasoft.controlltower.domain.Definitions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = Definitions.MODEL_MAPPER_BEAN_NAME)
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
