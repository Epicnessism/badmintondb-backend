package com.wangindustries.badmintondbbackend;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() { //? why do i have to create the bean for modelMapper but not my services?
        return new ModelMapper();
    }
}
