package com.aba.SpringSecuritySocle.security;

import com.aba.SpringSecuritySocle.security.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfig {

    private UserDetailsServiceImpl userDetailsService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers(antMatcher("/h2-console/**")).permitAll());
        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers(antMatcher("/favicon/**")).permitAll());

        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity.headers(header -> header.frameOptions(Customizer.withDefaults()).disable());
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.formLogin(form->form.defaultSuccessUrl("/api/todos"));
        httpSecurity.rememberMe(rem -> rem.alwaysRemember(false));

        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        httpSecurity.exceptionHandling(exp -> exp.accessDeniedPage("/noAuthorized"));
        httpSecurity.userDetailsService(userDetailsService);
        return httpSecurity.build();
    }
}
