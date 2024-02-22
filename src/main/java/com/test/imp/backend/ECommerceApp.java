package com.test.imp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ECommerceApp {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApp.class, args);
    }

}