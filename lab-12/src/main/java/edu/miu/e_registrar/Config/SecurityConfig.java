package edu.miu.e_registrar.Config;

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
public class SecurityConfig {
    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
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

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> {
//          web.ignoring()
//                  .antMatchers("/resources/static/**")
//                  .antMatchers("/css/**")
//                  .antMatchers("/images/**")
//                  .antMatchers("/js/**");
//        };
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
//                .cors()
//                .and()
//                .csrf().disable()
                .headers()
                .frameOptions().sameOrigin()
                .and()
//                .authenticationEntryPoint(unauthorizedHandler)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .authorizeRequests()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/", "/public/home", "/").permitAll()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/get/info/new").hasRole("ADMIN")
                .antMatchers("/get/info/search").hasRole("Student","ADMIN")
                .antMatchers("/get/info/list**").hasRole("Student","ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/public/login")
                .defaultSuccessUrl("/public/home")
                .failureUrl("/public/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/public/logout"))
                .logoutSuccessUrl("/public/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();
        httpSecurity.authenticationProvider(authenticationProvider());
        return httpSecurity.build();
    }

}
