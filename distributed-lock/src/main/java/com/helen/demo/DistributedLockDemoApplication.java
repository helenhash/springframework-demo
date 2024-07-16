package com.helen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:hazelcast.xml"})
@SpringBootApplication
public class DistributedLockDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedLockDemoApplication.class, args);
	}

}
