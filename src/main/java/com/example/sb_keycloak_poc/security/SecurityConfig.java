package com.example.sb_keycloak_poc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

    // @Bean
    // public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http)
    // {
    // http
    // .csrf().disable()
    // .authorizeExchange(exchanges -> exchanges
    // .pathMatchers("/get/products").permitAll()
    // .anyExchange().authenticated())
    // .oauth2ResourceServer(oauth2 -> oauth2
    // .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
    // return http.build();
    // }

    // @Bean
    // public JwtAuthenticationConverter jwtAuthenticationConverter() {
    // JwtAuthenticationConverter jwtAuthenticationConverter = new
    // JwtAuthenticationConverter();
    // jwtAuthenticationConverter.setPrincipalClaimName("preferred_username");
    // return jwtAuthenticationConverter;
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        // For every request, ask Spring Security to make sure it is authenticated
        http.authorizeHttpRequests(authorize -> {
            authorize.anyRequest().authenticated();
        });

        // For JWT, need configuration for issuer, so configure via
        // application.properties works well for authentication
        // http.oauth2ResourceServer(oauth2 -> {
        // oauth2.jwt(Customizer.withDefaults());
        // });

        // authorization
        http.oauth2ResourceServer(t -> {
            t.jwt(Customizer.withDefaults());
        });
        http.sessionManagement(t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation("http://localhost:8081/realms/satva");
    }
}