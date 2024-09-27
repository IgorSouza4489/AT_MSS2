package com.example.webfl;

import com.example.webfl.service.ExternalApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import reactor.test.StepVerifier;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class WebflApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ExternalApiService externalApiService;

	@Test
	public void testGetFirstPostExists() {
		StepVerifier.create(externalApiService.getPostById(1))
				.expectNext(true)
				.expectComplete()
				.verify();
	}

	@Test
	public void testGetPostDoesNotExist() {
		StepVerifier.create(externalApiService.getPostById(9999))
				.expectNext(false)
				.expectComplete()
				.verify();
	}

}
