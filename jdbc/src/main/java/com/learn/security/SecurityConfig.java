package com.learn.security;

import com.learn.security.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    @Order(1)
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        /*
         * requestMatchers로 특정 URI에 접근하려할 때
         * hasAuthority로 권한을 가진 사람만 authenticated하는 방법으로
         * authorization을 한다.
         */
        http
                .securityMatcher(antMatcher("/users/**"))
                .authorizeHttpRequests((authorize) -> {
                    authorize.requestMatchers(antMatcher(HttpMethod.GET)).authenticated();
                })
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain allowlogin(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> {
                    authorize.anyRequest().authenticated();
                });
        return http.build();
    }
    @Bean
    public CustomUserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }
}

/*
AuthenticationManager

ProviderManager는 AuthenticationManager를 구현한 것. 내부에 등록된 AuthenticationProvider들을 순회하며 인증을 한다.

AuthenticationProvider는 특정한 인증 절차를 구현하기 위해 정의된 인터페이스다.

DaoAuthenticationProvider는 UserDetailsService로부터 UserDetail 즉 사용자 정보를 갖고 올 수 있게 하는 AuthenticationProvider의 구현체다.

 */