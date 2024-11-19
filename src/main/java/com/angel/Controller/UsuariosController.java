package com.angel.Controller;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.angel.Entity.Usuario;
import com.angel.service.usuarioService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/usuarios")
@Tag(name = "Usuarios", description = "Gestión de usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosController {
    @Inject
    private usuarioService usuariServicio;

    @GET
    @Operation(summary = "Obtener todos los usuarios", description = "Retorna una lista con todos los usuarios registrados")
    public List<Usuario>obtenerUsuarios(){
        return usuariServicio.getAllUsuarios();
    }

    @POST
    @Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario y lo guarda en la base de datos")
    public String createUsuario(Usuario user){
        return usuariServicio.createUser(user);
    }
}
