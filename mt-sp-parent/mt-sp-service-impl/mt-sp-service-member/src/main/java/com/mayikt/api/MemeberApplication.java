package com.mayikt.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MemeberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemeberApplication.class, args);
    }
}
