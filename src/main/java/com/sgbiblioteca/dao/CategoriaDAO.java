package com.sgbiblioteca.dao;


import com.sgbiblioteca.modelo.Categorias;
import com.sgbiblioteca.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public List<Categorias> readAll() {
        List<Categorias> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Categorias(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar categorías: " + ex.getMessage());
        }

        return lista;
    }
}
