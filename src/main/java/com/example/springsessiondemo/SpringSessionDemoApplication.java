package com.example.springsessiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringSessionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionDemoApplication.class, args);
    }
}
