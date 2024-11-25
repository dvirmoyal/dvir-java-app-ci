package com.dvir.java.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // מבטל את CSRF למטרות בדיקה בלבד
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll() // מאפשר גישה חופשית לכתובת הראשית
                .anyRequest().authenticated(); // כל בקשה אחרת תדרוש אימות
        return http.build();
    }

}
