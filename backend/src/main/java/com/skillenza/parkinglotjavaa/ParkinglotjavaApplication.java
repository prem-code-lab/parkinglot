package com.skillenza.parkinglotjavaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableJpaAuditing
@RequestMapping("/parkinglot")
public class ParkinglotjavaApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ParkinglotjavaApplication.class, args);
	}

}
