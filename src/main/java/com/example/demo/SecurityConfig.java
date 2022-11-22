package com.example.demo;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf().disable()
                .cors().disable()
                .formLogin().disable()
                .logout().disable()
                .sessionManagement().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/orgs").authenticated()
                .requestMatchers(HttpMethod.GET, "/orgs/**").permitAll()
                .anyRequest().denyAll()
                .and()
                .httpBasic()
                .and()
                .build();
    }
}
