package com.wangindustries.badmintondbbackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

// todo follow this tutorial to finish security    https://www.baeldung.com/spring-security-login
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    }
}
