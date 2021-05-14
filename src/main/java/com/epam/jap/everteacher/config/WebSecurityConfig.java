package com.epam.jap.everteacher.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/*/finish/**", "/*/unfinish/**").hasRole("STUDENT")
                .antMatchers("/", "/*/block/**", "/*/unblock/**", "/list").hasRole("TEACHER")
                .anyRequest().permitAll()
                .and()
                .formLogin().defaultSuccessUrl("/students", true)
        ;
    }
}
