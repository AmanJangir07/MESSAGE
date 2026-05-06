package com.example.AVI_MESSAGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.avi_message.entity")
@EnableJpaRepositories("com.avi_message.repository")
public class AviMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(AviMessageApplication.class, args);
	}

}
