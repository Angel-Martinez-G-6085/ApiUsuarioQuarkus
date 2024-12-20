package com.angel.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.angel.Entity.Usuario;
import com.angel.Responses.CreateUserResponse;

@ApplicationScoped
public interface usuarioService {
    List<Usuario>getAllUsuarios();
    CreateUserResponse createUser(Usuario usuario);
}
