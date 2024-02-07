package com.example.flightsearchapi.config;

import com.example.flightsearchapi.model.Role;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security, HandlerMappingIntrospector introspector) throws Exception{

        MvcRequestMatcher.Builder mvcRequestBuilder = new MvcRequestMatcher.Builder(introspector);

        security
                .headers(x -> x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .csrf(csrfConfig ->
                        csrfConfig.ignoringRequestMatchers(mvcRequestBuilder.pattern("/**"))

                                .ignoringRequestMatchers(PathRequest.toH2Console()))
                .authorizeHttpRequests(x -> x
                                    .requestMatchers(mvcRequestBuilder.pattern("/api/flights/**")).permitAll()
                                    .requestMatchers(mvcRequestBuilder.pattern("/swagger-ui/**")).hasRole(Role.ROLE_ADMIN.getValue())
                                    .requestMatchers(mvcRequestBuilder.pattern("/api/airports/**")).hasRole(Role.ROLE_ADMIN.getValue())
                                    .requestMatchers(PathRequest.toH2Console()).hasRole("ADMIN")
                                    .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        return security.build();

    }
}

