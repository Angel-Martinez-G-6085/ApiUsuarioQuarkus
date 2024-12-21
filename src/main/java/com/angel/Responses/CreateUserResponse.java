package com.angel.Responses;

import com.angel.Entity.Usuario;

public class CreateUserResponse extends GlogalResponse {

    private Usuario usuario;

    public CreateUserResponse(String status, String message, Usuario usuario) {
        super( status,message);
        this.usuario = usuario;
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario user) {
        this.usuario = user;
    }
}
