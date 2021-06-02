package com.seethec.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.seethec.api.entity.UserTableRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserTableRepository.class)
public class SimpleJwtAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleJwtAuthApplication.class, args);
	}

}
