package com.example.webfl.service;

import com.example.webfl.model.Usuario;
import com.example.webfl.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Flux<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Mono<Usuario> save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
