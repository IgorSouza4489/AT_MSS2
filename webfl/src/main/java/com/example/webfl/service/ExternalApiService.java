package com.example.webfl.service;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ExternalApiService {
    private final WebClient webClient;

    public ExternalApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public Flux<String> getPosts() {
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(String.class)
                .onErrorResume(e -> Flux.just("Erro ao obter dados: " + e.getMessage()));
    }

    public Mono<Boolean> getPostById(int id) {
        return webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(String.class)
                .map(post -> !post.isEmpty())
                .defaultIfEmpty(false)
                .onErrorReturn(false);
    }
}
