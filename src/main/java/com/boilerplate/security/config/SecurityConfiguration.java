package com.boilerplate.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http
            .authorizeRequests()
                .antMatchers("/api/person/dashboard")
                .authenticated()
                .and()
            .authorizeRequests()
                .antMatchers("/api/person/hello").permitAll();
        return http.build();
    }

}
