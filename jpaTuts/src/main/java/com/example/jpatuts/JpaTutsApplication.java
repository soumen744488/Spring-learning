package com.example.jpatuts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.jpatuts", "com.repositories"})
@EnableJpaRepositories(basePackages = "com.repositories")
public class JpaTutsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTutsApplication.class, args);
	}

}
