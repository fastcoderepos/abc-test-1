package com.fastcode.aaaloc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.fastcode.aaaloc"})
public class AaalocApplication {

	public static void main(String[] args) {
		SpringApplication.run(AaalocApplication.class, args);
	}

}

