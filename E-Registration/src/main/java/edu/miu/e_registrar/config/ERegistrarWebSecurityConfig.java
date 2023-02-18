package edu.miu.e_registrar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
public class ERegistrarWebSecurityConfig {

    private UserDetailsService userDetailsService;

    @Autowired
    public ERegistrarWebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .requestMatchers("/resources/static/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/images/**").permitAll()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/get/menu").permitAll()
                .requestMatchers("/", "/get", "/get/login").permitAll()
                //.requestMatchers("/get/**").permitAll()
                .requestMatchers("/eregistrar/sysadmin/**").hasRole("admin")
               // .requestMatchers("/get/menu/**").hasRole("LIBRARIAN")

            //   .requestMatchers("/get/menu/**").hasRole("LIBMEMBER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/get/login")
                .defaultSuccessUrl("/get/menu")
                .failureUrl("/get/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/public/logout"))
                .logoutSuccessUrl("/get/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();
        httpSecurity.authenticationProvider(authenticationProvider());
        return httpSecurity.build();
    }

}

