package com.sgbiblioteca.vista;

import javax.swing.*;
import java.awt.*;
import com.sgbiblioteca.dao.LibroDAO;
import com.sgbiblioteca.modelo.Libros;

public class LibrosPanel extends JPanel {

    public JTextField txtTitulo, txtAutor, txtIsbn, txtEditorial, txtStock;
    public JButton btnGuardar, btnActualizar, btnEliminar;

    public LibrosPanel() {

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTitulo = new JLabel("Gestión de Libros");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel panelTitulo = new JPanel();
        panelTitulo.add(lblTitulo);

        JPanel formulario = new JPanel(new GridLayout(0, 2, 5, 5));
        formulario.setBorder(BorderFactory.createTitledBorder("Datos del Libro"));

        txtTitulo = new JTextField();
        txtTitulo.setPreferredSize(new Dimension(150, 25));

        txtAutor = new JTextField();
        txtAutor.setPreferredSize(new Dimension(150, 25));

        txtIsbn = new JTextField();
        txtIsbn.setPreferredSize(new Dimension(150, 25));

        txtEditorial = new JTextField();
        txtEditorial.setPreferredSize(new Dimension(150, 25));

        txtStock = new JTextField();
        txtStock.setPreferredSize(new Dimension(150, 25));

        formulario.add(new JLabel("Título:"));
        formulario.add(txtTitulo);

        formulario.add(new JLabel("Autor:"));
        formulario.add(txtAutor);

        formulario.add(new JLabel("ISBN:"));
        formulario.add(txtIsbn);

        formulario.add(new JLabel("Editorial:"));
        formulario.add(txtEditorial);

        formulario.add(new JLabel("Stock:"));
        formulario.add(txtStock);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);

        btnGuardar.addActionListener(e -> {
            try {
                LibroDAO dao = new LibroDAO();

                Libros libro = new Libros(
                        0,
                        txtTitulo.getText(),
                        txtAutor.getText(),
                        txtIsbn.getText(),
                        txtEditorial.getText(),
                        Integer.parseInt(txtStock.getText()),
                        1
                );

                if (dao.create(libro)) {
                    JOptionPane.showMessageDialog(this, "Guardado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        });

        add(panelTitulo, BorderLayout.NORTH);
        add(formulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void limpiarCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtIsbn.setText("");
        txtEditorial.setText("");
        txtStock.setText("");
    }
}
