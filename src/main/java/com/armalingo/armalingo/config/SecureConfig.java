package com.armalingo.armalingo.config;

import com.armalingo.armalingo.service.StudentDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecureConfig {
    private final StudentDetailsService studentDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
               .csrf(Customizer.withDefaults())
               .authorizeHttpRequests((requests) -> requests
                       .requestMatchers("/","/main","/error","/registration").permitAll()
                       .anyRequest().hasAnyRole("USER","ADMIN")
               )
               .formLogin((form) -> form
                       .defaultSuccessUrl("/main")
                       .permitAll()
               )
               .logout((logout) -> logout
                       .logoutSuccessUrl("/main")
               )

               .build();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(studentDetailsService);
        return daoAuthenticationProvider;
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

