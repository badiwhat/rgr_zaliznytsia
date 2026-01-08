package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Вимикаємо CSRF для спрощення розробки
                .authorizeHttpRequests(auth -> auth
                        // Всі запити за адресою /admin/... доступні тільки ролі ADMIN
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        // Головна сторінка та стилі доступні всім авторизованим
                        .requestMatchers("/", "/css/**", "/js/**").authenticated()
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults()) // Стандартна форма входу
                .logout(logout -> logout.logoutSuccessUrl("/login")); // При виході перенаправляємо на логін

        return http.build();
    }
}