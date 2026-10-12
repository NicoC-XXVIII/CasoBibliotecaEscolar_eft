package com.sgbiblioteca.dao;

import com.sgbiblioteca.modelo.Libros;
import com.sgbiblioteca.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public boolean create(Libros l) {
        String sql = "INSERT INTO libros(titulo, autor, isbn, editorial, stock, id_categoria) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getIsbn());
            ps.setString(4, l.getEditorial());
            ps.setInt(5, l.getStock());
            ps.setInt(6, l.getIdCategoria());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al crear libro: " + ex.getMessage());
            return false;
        }
    }

    public List<Libros> readAll() {
        List<Libros> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Libros(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("isbn"),
                        rs.getString("editorial"),
                        rs.getInt("stock"),
                        rs.getInt("id_categoria")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar libros: " + ex.getMessage());
        }

        return lista;
    }

    public int obtenerStock(int idLibro) {
        String sql = "SELECT stock FROM libros WHERE id = ?";
        int stock = -1;

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idLibro);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    stock = rs.getInt("stock");
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener stock: " + ex.getMessage());
        }

        return stock;
    }


    // Método synchronized para evitar condiciones de carrera
    public synchronized boolean actualizarStock(int idLibro, int nuevoStock) {
        String sql = "UPDATE libros SET stock = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, nuevoStock);
            ps.setInt(2, idLibro);

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al actualizar stock: " + ex.getMessage());
            return false;
        }
    }
}
