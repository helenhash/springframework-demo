package com.helen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.helen.demo"})
public class DataJPADemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJPADemoApplication.class, args);
	}

}
