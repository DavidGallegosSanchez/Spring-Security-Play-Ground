package com.gallegos.springsecuritybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// This annotation is necessary only if the controller is outside of com.gallegos.springsecuritybasic
@ComponentScan("com.gallegos.springsecuritybasic.controller")
public class SpringsecuritybasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritybasicApplication.class, args);
	}

}
