package com.armalingo.armalingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ArmaLingoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArmaLingoApplication.class, args);
    }

}
