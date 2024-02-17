package com.armalingo.armalingo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecureConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
               .csrf(Customizer.withDefaults())
               .authorizeHttpRequests((requests) -> requests
                       .requestMatchers("/","/main","/error","api/student/registration", "/api/student/1").permitAll()
                       .anyRequest().hasAnyRole("USER","ADMIN")
               )
//               .formLogin((form) -> form
//                       .defaultSuccessUrl("/myaccount")
//                       .permitAll()
//               )
               .logout((logout) -> logout
                       .logoutSuccessUrl("/main")
               )

               .build();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

