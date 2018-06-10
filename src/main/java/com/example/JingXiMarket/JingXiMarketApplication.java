package com.example.JingXiMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class JingXiMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(JingXiMarketApplication.class, args);
	}
}
