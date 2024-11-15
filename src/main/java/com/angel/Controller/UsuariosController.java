package com.angel.Controller;

import java.util.List;

import com.angel.Entity.Usuario;
import com.angel.service.usuarioService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/usuarios")
public class UsuariosController {
    @Inject
    private usuarioService usuariServicio;

    @GET
    public List<Usuario>obtenerUsuarios(){
        return usuariServicio.getAllUsuarios();
    }

    @POST
    public String createUsuario(Usuario user){
        return usuariServicio.createUser(user);
    }
}
