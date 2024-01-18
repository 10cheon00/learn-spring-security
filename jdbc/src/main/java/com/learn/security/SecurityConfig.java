package com.learn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public CustomeUserDetailsService userDetailsService(){
        return new CustomeUserDetailsService();
    }
}

/*
AuthenticationManager

ProviderManager는 AuthenticationManager를 구현한 것. 내부에 등록된 AuthenticationProvider들을 순회하며 인증을 한다.

AuthenticationProvider는 특정한 인증 절차를 구현하기 위해 정의된 인터페이스다.

DaoAuthenticationProvider는 UserDetailsService로부터 UserDetail 즉 사용자 정보를 갖고 올 수 있게 하는 AuthenticationProvider의 구현체다.

 */