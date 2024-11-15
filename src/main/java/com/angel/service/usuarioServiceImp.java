package com.angel.service;

import java.util.List;

import com.angel.Dao.UserDao;
import com.angel.Entity.Usuario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class usuarioServiceImp implements usuarioService {
    @Inject
    UserDao userDao;

    @Override
    public List<Usuario> getAllUsuarios() {
        return userDao.findAllCustomers();
    }

    @Override
    public String createUser(Usuario usuario) {
        userDao.crearUsuarios(usuario);
        return "Usuario creado correctamente";
    }
    
}
