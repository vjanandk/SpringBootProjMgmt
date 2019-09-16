package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringBootProjMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjMgmtApplication.class, args);
		System.out.println("Welcome to Spring Boot Rest Project Management Application");
	}

}
