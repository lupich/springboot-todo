package com.luismi.crus_task.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(
            authoriz->authoriz.requestMatchers("/api/v1/user","/api/v1/task")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(management->management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .build();
  }

}
