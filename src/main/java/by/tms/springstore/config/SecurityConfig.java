package by.tms.springstore.config;

import static by.tms.springstore.utils.Constants.Attributes.ADMIN;
import static by.tms.springstore.utils.Constants.PagePath.ABOUT_US_CONTROLLER;
import static by.tms.springstore.utils.Constants.PagePath.ACTIVATE_ALL;
import static by.tms.springstore.utils.Constants.PagePath.ADMIN_ALL;
import static by.tms.springstore.utils.Constants.PagePath.AUTH_ALL;
import static by.tms.springstore.utils.Constants.PagePath.FORGOT_PASSWORD;
import static by.tms.springstore.utils.Constants.PagePath.HOME_CONTROLLER;
import static by.tms.springstore.utils.Constants.PagePath.RESET_PASSWORD;
import static by.tms.springstore.utils.Constants.PagePath.ROOT;
import static by.tms.springstore.utils.Constants.PagePath.USER_AGREEMENT;

import by.tms.springstore.handler.CustomAuthenticationSuccessHandler;
import by.tms.springstore.handler.CustomLogoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomLogoutHandler customLogoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(ADMIN_ALL).hasRole(ADMIN)
                                .requestMatchers(ROOT, AUTH_ALL, USER_AGREEMENT, ACTIVATE_ALL, FORGOT_PASSWORD, RESET_PASSWORD, HOME_CONTROLLER, ABOUT_US_CONTROLLER).permitAll()
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .anyRequest().hasAnyRole("USER", ADMIN)
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/auth/login")
                                .successHandler(customAuthenticationSuccessHandler)
                                .permitAll()
                ).logout(logout ->
                        logout
                                .logoutUrl("/auth/logout")
                                .logoutSuccessHandler(customLogoutHandler)
                                .logoutSuccessUrl("/auth/login?logout")
                                .deleteCookies("JSESSIONID")
                                .permitAll())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
