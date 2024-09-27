package com.example.webfl.controller;

import com.example.webfl.model.Usuario;
import com.example.webfl.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public Flux<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Usuario> createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
}
