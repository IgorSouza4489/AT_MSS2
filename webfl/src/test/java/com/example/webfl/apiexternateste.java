package com.example.webfl;

import com.example.webfl.service.ExternalApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

@SpringBootTest
public class apiexternateste {

    @Autowired
    private ExternalApiService externalApiService;

    @Test
    public void testGetPosts() {
        StepVerifier.create(externalApiService.getPosts())
                .expectNextMatches(post -> post.contains("title")) // Verifique se a resposta contém "title"
                .expectNextCount(99) // Verifique os outros 99 posts
                .verifyComplete();
    }
}
