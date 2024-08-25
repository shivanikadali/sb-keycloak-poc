package com.example.sb_keycloak_poc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        // For every request, ask Spring Security to make sure it is authenticated
        http.authorizeHttpRequests(authorize -> {
            authorize
                    .requestMatchers(HttpMethod.GET, "/authenticated").permitAll()
                    .anyRequest().authenticated();
        });

        // authorization
        http.oauth2ResourceServer(t -> {
            t.jwt(configurer->configurer.jwtAuthenticationConverter(jwtAuthConverter));
        
        });

        http.sessionManagement(t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
   @Bean
   public DefaultMethodSecurityExpressionHandler msecurity(){
    DefaultMethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler=new DefaultMethodSecurityExpressionHandler();
    defaultMethodSecurityExpressionHandler.setDefaultRolePrefix("");
    return defaultMethodSecurityExpressionHandler;
   }
}