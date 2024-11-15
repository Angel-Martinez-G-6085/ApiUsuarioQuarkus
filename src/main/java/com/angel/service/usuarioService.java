package com.angel.service;

import java.util.List;

import com.angel.Entity.Usuario;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface usuarioService {
    List<Usuario>getAllUsuarios();
    String createUser(Usuario usuario);
}
