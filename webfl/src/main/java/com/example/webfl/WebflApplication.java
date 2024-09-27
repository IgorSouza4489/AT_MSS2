package com.example.webfl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebflApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebflApplication.class, args);
	}

	//CLIENTE REATIVO
	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}
}
