package com.example.AVI_MESSAGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.AVI_MESSAGE.entity")
@EnableJpaRepositories("com.example.AVI_MESSAGE.repository")
public class AviMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AviMessageApplication.class, args);
    }
}