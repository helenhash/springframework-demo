package com.helen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.helen.demo"})
public class DataJPADemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJPADemoApplication.class, args);
	}

}
