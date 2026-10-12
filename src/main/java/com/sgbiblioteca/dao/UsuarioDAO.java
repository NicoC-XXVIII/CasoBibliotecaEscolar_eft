package com.sgbiblioteca.dao;

import com.sgbiblioteca.database.DatabaseConnection;
import com.sgbiblioteca.modelo.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public Usuarios autenticar(String correo, String clave) {

        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contraseña = ?";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, clave);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuarios(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("rut"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getString("rol")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
