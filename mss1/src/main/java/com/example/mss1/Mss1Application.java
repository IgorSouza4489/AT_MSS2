package com.example.mss1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Mss1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mss1Application.class, args);
	}


	@RestController
	class StatusController {

		@GetMapping("/status")
		public String status() {
			return "O serviço está ativo!";
		}
	}
}

