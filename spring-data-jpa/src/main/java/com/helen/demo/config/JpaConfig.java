package com.helen.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.helen.demo.repository")
@Configuration
public class JpaConfig {

}
