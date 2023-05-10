package com.simpel.restapi.simpelrestapi.config;

import com.simpel.restapi.simpelrestapi.mapper.ProductMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new ProductMapper());
        return modelMapper;
    }
}