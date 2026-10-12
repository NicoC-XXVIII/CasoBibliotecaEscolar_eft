package com.sgbiblioteca.dao;

import com.sgbiblioteca.modelo.Estudiantes;
import com.sgbiblioteca.util.ValidadorRUT;
import com.sgbiblioteca.excepciones.RutInvalidoException;
import com.sgbiblioteca.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    public boolean create(Estudiantes e) {
        String sql = "INSERT INTO estudiantes(nombre, rut, curso, correo) VALUES(?,?,?,?)";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ValidadorRUT.validar(e.getRut());

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getRut());
            ps.setString(3, e.getCurso());
            ps.setString(4, e.getCorreo());

            return ps.executeUpdate() > 0;

        } catch (SQLException | RutInvalidoException ex) {
            System.out.println("Error al crear estudiante: " + ex.getMessage());
            return false;
        }
    }

    public List<Estudiantes> readAll() {
        List<Estudiantes> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Estudiantes(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("rut"),
                        rs.getString("curso"),
                        rs.getString("correo")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar estudiantes: " + ex.getMessage());
        }

        return lista;
    }
}
