package com.angel.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import com.angel.Entity.Usuario;
import com.angel.Responses.CreateUserResponse;
import com.angel.service.usuarioService;


@Path("/usuarios")
@Tag(name = "Usuarios", description = "Gestión de usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosController {

    private Logger LOGGER = Logger.getLogger(UsuariosController.class);

    @Inject
    usuarioService usuariServicio;

    @GET
    @Operation(summary = "Obtener todos los usuarios", description = "Retorna una lista con todos los usuarios registrados")
    public List<Usuario>obtenerUsuarios(){
        LOGGER.info("Se listaron todos los usuarios en la base de datos");
        return usuariServicio.getAllUsuarios();
    }

    @POST
    @Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario y lo guarda en la base de datos")
    public CreateUserResponse createUsuario(Usuario user){
        LOGGER.info("Se creo un nuevo usuario en la base de datos");
        return usuariServicio.createUser(user);
    }
}
