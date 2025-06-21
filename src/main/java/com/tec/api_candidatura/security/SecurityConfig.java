package com.tec.api_candidatura.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] PUBLIC_MATCHERS = { "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/swagger-resource/**"};

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(PUBLIC_MATCHERS).permitAll() // permissão visual

                        // Login
                        .requestMatchers(HttpMethod.POST, "/api/v7/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v7/auth/login").permitAll()

                        // CANDIDATURES
                        .requestMatchers(HttpMethod.POST, "/api/v7/candidatures/apply").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/v7/candidatures/").authenticated()

                        .requestMatchers(HttpMethod.PATCH, "/api/v7/candidatures/{id}/status").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/api/v7/candidatures/my/{id}/status").authenticated()

                        .requestMatchers(HttpMethod.GET, "/api/v7/candidatures").hasAuthority("ROLE_ADMIN")

                        // VACANCIES
                        .requestMatchers(HttpMethod.POST, "/api/v7/vacancies").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/v7/vacancies").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/v7/vacancies/{id}").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v7/vacancies/{id}").hasAuthority("ROLE_ADMIN")

                        // USERS
                        .requestMatchers(HttpMethod.GET, "/api/v7/users/getIdUser").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/v7/users/getAllUsers").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v7/users/{id}").authenticated()

                        .anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
