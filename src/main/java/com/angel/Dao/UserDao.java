package com.angel.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.angel.Entity.Usuario;

public class UserDao {
    private static final String URL = "jdbc:mysql://server:3306/Usuarios";
    private static final String USER = "admon";
    private static final String PASSWORD = "acuario248";

    public void crearUsuarios(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, apellido, correo, edad) VALUES ( ?, ?, ?, ? )";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(0, usuario.getNombre());
            stmt.setString(1, usuario.getApellido());
            stmt.setString(2, usuario.getCorreo());
            stmt.setInt(3, usuario.getEdad());

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
