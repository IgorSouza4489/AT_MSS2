package com.example.webfl;

import org.springframework.boot.SpringApplication;

public class TestWebflApplication {

	public static void main(String[] args) {
		SpringApplication.from(WebflApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
