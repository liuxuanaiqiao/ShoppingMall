package com.mayikt.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.mayikt.api.impl.mapper")
@EnableFeignClients
@SpringBootApplication
public class MemeberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemeberApplication.class, args);
    }
}
