package com.wangindustries.badmintondbbackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

    //todo temporary usage of users
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoderTest().encode("pass"))
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoderTest().encode("user2Pass"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoderTest().encode("adminPass"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoderTest() {
        return new BCryptPasswordEncoder();
    }

// todo follow this tutorial to finish security    https://www.baeldung.com/spring-security-login
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((AbstractHttpConfigurer::disable));

        http
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests.anyRequest().anonymous()
//                                .requestMatchers("/**").hasRole("tester")
                );
//                .formLogin((formLogin) ->
//                        formLogin
//                                .usernameParameter("username")
//                                .passwordParameter("password")
//                                .loginPage("/authentication/login")
//                                .failureUrl("/authentication/login?failed")
//                                .loginProcessingUrl("/authentication/login/process")
//                );
        return http.build();
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/admin/**")
//                .hasRole("ADMIN")
//                .antMatchers("/anonymous*")
//                .anonymous()
//                .antMatchers("/login*")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
    }
}
