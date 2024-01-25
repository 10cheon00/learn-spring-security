package com.learn.security;

import com.learn.security.service.CustomUserDetailsService;
import jakarta.servlet.DispatcherType.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static jakarta.servlet.DispatcherType.ERROR;
import static jakarta.servlet.DispatcherType.FORWARD;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .dispatcherTypeMatchers(FORWARD, ERROR).permitAll()
                        .requestMatchers("/login/**").permitAll()
                        .requestMatchers("/users/**").hasAuthority("READ")
                        .requestMatchers("/sample/**").hasRole("ADMIN")
                        .anyRequest().denyAll());
        return http.build();
    }

    @Bean
    public CustomUserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
}

/*
AuthenticationManager

ProviderManager는 AuthenticationManager를 구현한 것. 내부에 등록된 AuthenticationProvider들을 순회하며 인증을 한다.

AuthenticationProvider는 특정한 인증 절차를 구현하기 위해 정의된 인터페이스다.

DaoAuthenticationProvider는 UserDetailsService로부터 UserDetail 즉 사용자 정보를 갖고 올 수 있게 하는 AuthenticationProvider의 구현체다.

 */