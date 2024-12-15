package com.angel.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.angel.Entity.Usuario;

@ApplicationScoped
public class UserDao {
    @ConfigProperty(name = "quarkus.datasource.jdbc.url")
    String URL;

    @ConfigProperty(name = "quarkus.datasource.username")
    String USER;

    @ConfigProperty(name = "quarkus.datasource.password")
    String PASSWORD;

    public void crearUsuarios(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, apellido, correo, edad) VALUES ( ?, ?, ?, ? )";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getCorreo());
            stmt.setInt(4, usuario.getEdad());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> findAllCustomers() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuariosList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setEdad(rs.getInt("edad"));
                usuariosList.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuariosList;
    }
}
