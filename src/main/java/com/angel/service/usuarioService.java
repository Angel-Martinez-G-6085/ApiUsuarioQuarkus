package com.angel.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.angel.Entity.Usuario;

@ApplicationScoped
public interface usuarioService {
    List<Usuario>getAllUsuarios();
    String createUser(Usuario usuario);
}
