package by.tms.springstore.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
//                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests((auth) ->
                                auth

                                        .requestMatchers("/admin").hasRole("ADMIN")
                                        .requestMatchers("/auth/login", "/auth/registration", "/open").permitAll()
                                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                        .anyRequest().hasAnyRole("USER", "ADMIN")
//                                        .anyRequest().authenticated()
                )
                .formLogin((formLogin) ->
                        formLogin

                                .loginPage("/auth/login")
                                .defaultSuccessUrl("/home", true)
                ).logout((logout) ->
                        logout.logoutUrl("/auth/logout")
                                .logoutSuccessUrl("/auth/login")
                                .permitAll())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}