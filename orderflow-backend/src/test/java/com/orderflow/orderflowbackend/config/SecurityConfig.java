package com.orderflow.orderflowbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Отключение CSRF (для тестирования)
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/auth/register", "/h2-console/**").permitAll()  // Разрешить доступ к регистрации и H2 Console
                    .anyRequest().authenticated()  // Все остальные запросы требуют аутентификации
            )
            .formLogin(form -> form.permitAll())  // Разрешить доступ к форме логина
            .logout(logout -> logout.permitAll())  // Включение возможности логаута
            .headers(headers -> headers
                    .defaultsDisabled()  // Отключаем все заголовки по умолчанию
                    .frameOptions(frame -> frame.sameOrigin())  // Разрешить использование фреймов для H2 Console
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
