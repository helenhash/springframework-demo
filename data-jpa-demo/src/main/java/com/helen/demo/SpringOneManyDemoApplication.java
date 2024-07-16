package com.helen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.helen.demo"})
@EnableJpaRepositories(basePackages = "com.helen.demo.repository")
public class SpringOneManyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOneManyDemoApplication.class, args);
	}

}
