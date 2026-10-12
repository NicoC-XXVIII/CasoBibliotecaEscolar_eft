package com.sgbiblioteca.dao;

import com.sgbiblioteca.modelo.Prestamos;
import com.sgbiblioteca.database.DatabaseConnection;

import java.sql.*;

public class PrestamoDAO {

    public boolean registrarPrestamo(Prestamos p) {
        String sql = "INSERT INTO prestamos(id_estudiante, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES(?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getIdEstudiante());
            ps.setInt(2, p.getIdLibro());
            ps.setDate(3, java.sql.Date.valueOf(p.getFechaPrestamo()));
            ps.setDate(4, java.sql.Date.valueOf(p.getFechaDevolucion()));
            ps.setBoolean(5, p.isDevuelto());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al registrar préstamo: " + ex.getMessage());
            return false;
        }
    }

    public boolean marcarDevuelto(int idPrestamo) {
        String sql = "UPDATE prestamos SET devuelto = 1 WHERE id = ?";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idPrestamo);
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al marcar devolución: " + ex.getMessage());
            return false;
        }
    }
}
