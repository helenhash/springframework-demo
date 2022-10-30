package com.helen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.helen.demo", "giau.utils"})
public class SpringRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDemoApplication.class, args);
	}

}
