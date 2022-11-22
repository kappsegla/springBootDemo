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
    //             .csrf().disable()
    //             .cors().disable()
    //             .formLogin().disable()
    //             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //             .and()
    //             .authorizeHttpRequests()
    //             .requestMatchers(HttpMethod.GET, "/geo/**").permitAll()
    //             .requestMatchers("/playgrounds/**").authenticated()
    //             .anyRequest().denyAll()
    //             .and()
    //             .httpBasic()
    //             .and()
                .build();
    }
}
