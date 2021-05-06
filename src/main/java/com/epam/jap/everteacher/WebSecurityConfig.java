//package com.epam.jap.everteacher;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers( "/","/add","/save").permitAll()
////                .antMatchers( "/hello").hasRole("STUDENT")
////                .antMatchers( "/hi","/hello").hasRole("TEACHER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
////    @Bean
////    @Override
////    public UserDetailsService userDetailsService() {
////        List<UserDetails> users = new ArrayList<>();
////        UserDetails user =
////                User.withDefaultPasswordEncoder()
////                        .username("student")
////                        .password("student")
////                        .roles("STUDENT")
////                        .build();
////
////        UserDetails teacher =
////                User.withDefaultPasswordEncoder()
////                        .username("teacher")
////                        .password("teacher")
////                        .roles("TEACHER")
////                        .build();
////
////        users.add(user);
////        users.add(teacher);
////
////        return new InMemoryUserDetailsManager(users);
////    }
//}