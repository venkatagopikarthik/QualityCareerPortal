package com.Task1.demoTask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
        
        private final UserDetailsService userDetailsService;
        private final PasswordEncoder passwordEncoder;

        public AdminSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
            this.userDetailsService = userDetailsService;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/admin/**")
                .authorizeRequests()
                    .antMatchers("/admin/login", "/admin/process-login").permitAll()
                    .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                    .and()
                .formLogin()
                    .loginPage("/admin/login")
                    .loginProcessingUrl("/admin/process-login")
                    .usernameParameter("adminId")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/admin/addemployee")
                    .failureUrl("/admin/login?error=true")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/admin/logout")
                    .logoutSuccessUrl("/admin/login")
                    .and()
                .exceptionHandling()
                    .accessDeniedPage("/admin/login?error=access_denied")
                    .and()
                .csrf().disable();
        }
    }

    @Configuration
    @Order(2)
    public static class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter {
        
        private final UserDetailsService userDetailsService;
        private final PasswordEncoder passwordEncoder;

        public EmployeeSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
            this.userDetailsService = userDetailsService;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/employee/**")
                .authorizeRequests()
                    .antMatchers("/employee/login", "/employee/process-login").permitAll()
                    .antMatchers("/employee/form").hasAuthority("ROLE_EMPLOYEE")
                    .antMatchers("/employee/dashboard", "/employee/create", "/employee/edit/**", "/employee/delete/**").hasAuthority("ROLE_ADMIN")
                    .antMatchers("/employee/**").hasAuthority("ROLE_EMPLOYEE")
                    .and()
                .formLogin()
                    .loginPage("/employee/login")
                    .loginProcessingUrl("/employee/process-login")
                    .usernameParameter("employeeId")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/employee/form", true)
                    .failureUrl("/employee/login?error=true")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/employee/logout")
                    .logoutSuccessUrl("/employee/login")
                    .and()
                .exceptionHandling()
                    .accessDeniedPage("/employee/login?error=access_denied")
                    .and()
                .csrf().disable();
        }
    }

    @Configuration
    @Order(3)
    public static class DefaultSecurityConfig extends WebSecurityConfigurerAdapter {
        
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/")
                    .permitAll()
                    .and()
                .csrf().disable();
        }
    }
}