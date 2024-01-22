package com.ob.tsb.accounts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(exchanges ->
                exchanges.pathMatchers("/**").permitAll()
                        /* To do implementation
                        .pathMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
                        .pathMatchers("/admin/**").hasRole("ADMIN")*/
                        .anyExchange().authenticated()
        ).csrf(csrfSpec -> csrfSpec.disable()); // Disable CSRF for simplicity, consider enabling in a production environment

        return http.build();
    }
}
