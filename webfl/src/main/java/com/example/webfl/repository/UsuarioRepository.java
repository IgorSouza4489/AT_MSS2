package com.example.webfl.repository;


import com.example.webfl.model.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long> {
}

