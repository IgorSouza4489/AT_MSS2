package com.example.webfl.controller;


import com.example.webfl.service.ExternalApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class JsonController {
    private final ExternalApiService externalApiService;

    public JsonController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/posts")
    public Flux<String> getPosts() {
        return externalApiService.getPosts();
    }

    @GetMapping("/posts/{id}")
    public Mono<Boolean> getPostById(@PathVariable int id) {
        return externalApiService.getPostById(id);
    }
}

