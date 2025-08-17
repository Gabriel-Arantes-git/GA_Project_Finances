package com.GA_Project.GA_Finances.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/cadastro").permitAll()
                        .requestMatchers(HttpMethod.GET, "/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/cadastro/recuperar_senha").permitAll()
                        .requestMatchers(HttpMethod.GET, "/cadastro/validarToken").permitAll()
                        .requestMatchers(HttpMethod.POST, "/cadastrar/usuario").permitAll()
                        .requestMatchers(HttpMethod.GET, "/homepage/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/gastos-despesas/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/adicionar_transferencia/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuario/{id}/transacoes").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}