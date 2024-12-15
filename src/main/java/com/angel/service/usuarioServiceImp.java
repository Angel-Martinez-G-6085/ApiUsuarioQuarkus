package com.angel.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.angel.Dao.UserDao;
import com.angel.Entity.Usuario;

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
