package com.bernice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.bernice")
@EntityScan(basePackages = "com.bernice.entity")
@EnableJpaRepositories(basePackages = "com.bernice.model.persistence")
public class AccountSpringBootMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountSpringBootMvcProjectApplication.class, args);
	}

}
