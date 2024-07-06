package com.gallegos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableJpaRepositories("com.gallegos.repository")
//@EntityScan("com.gallegos.model")
@EnableWebSecurity(debug = true) // Security debugging is enabled -> Do not use in a production system!
public class BankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankBackendApplication.class, args);
	}

}
