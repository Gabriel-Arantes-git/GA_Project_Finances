package com.GA_Project.GA_Finances.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Certifique-se de que esta é a primeira regra para o endpoint de cadastro
                        .requestMatchers(HttpMethod.POST, "/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/cadastrar/{email}").permitAll()
                        // Todas as outras requisições requerem autenticação
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}