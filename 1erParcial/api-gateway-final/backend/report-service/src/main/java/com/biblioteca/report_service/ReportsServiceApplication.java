package com.biblioteca.report_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ReportsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReportsServiceApplication.class, args);
    }
}
