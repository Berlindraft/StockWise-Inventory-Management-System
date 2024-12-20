package com.inventory.stockwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.inventory.stockwise")
@EnableJpaRepositories(basePackages = "com.inventory.stockwise.repository")
@EnableAutoConfiguration

public class StockwiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockwiseApplication.class, args);
	}

}

