package com.mygaienko.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mygaienko.model.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.io.OutputStream;

/**
 * Created by enda1n on 09.11.2016.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .sessionManagement()
                    .maximumSessions(1)/*.expiredUrl("")*/
                    .and()
                    .sessionFixation().migrateSession()
                .and()
                    .authorizeRequests()
                        .antMatchers("/css/**", "/index", "/h2-console/**").permitAll()
                        .antMatchers("/user*").hasAnyRole("ADMIN", "USER")
                .and()
                    .formLogin().loginPage("/login").successHandler(authenticationSuccessHandler())
                    .failureHandler(authenticationFailureHandler())
                .and()
                    .rememberMe().tokenValiditySeconds(6000)
                .and()
                    .x509();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new ForwardAuthenticationSuccessHandler("/user/me");
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return ((request, response, exception) -> {
            try (OutputStream out = response.getOutputStream()) {
                UserInfo user = new UserInfo();
                user.setUsername("INVALID");
                objectMapper.writeValue(out, user);
            }
        });
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(16);
    }

}
