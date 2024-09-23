package com.riwi.complexus.infrastructure.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration // beans
@AllArgsConstructor
public class SecurityConfig {

    @Autowired
    private final JwtFilter jwtFilter;

//    @Autowired
//    private RolsEntity role;

    @Autowired
    private final AuthenticationProvider authenticationProvider;

//    @Autowired
//    RolsEntity roleAdmin;
//
//    @Autowired
//    RolsEntity roleResident;

    private final String[] PUBLIC_ENDPOINTS = {"/auth/login",
            "resident/readById/{}","/user/admin/register","/user/delete/{}" ,"/user/readById/{}","/user/update/{}","/user/register",
            "/residentialUnit/createUnit", "/residentialUnit/deleteUnit/{}",
            "/residentialUnit/readAllUnit","/residentialUnit/readByIdUnit/{}","/residentialUnit/updateUnit/{}","/swagger-ui/**", "/v3/api-docs/**" };

    private final String[] ADMIN_ENDPOINTS = { "/resident/**" };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers(ADMIN_ENDPOINTS).hasAnyAuthority("admin","superadmin")
                                .requestMatchers(PUBLIC_ENDPOINTS).permitAll()
                                .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider)
                .sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}