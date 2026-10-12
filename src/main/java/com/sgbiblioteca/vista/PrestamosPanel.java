package com.sgbiblioteca.vista;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

import com.sgbiblioteca.dao.EstudianteDAO;
import com.sgbiblioteca.dao.LibroDAO;
import com.sgbiblioteca.dao.PrestamoDAO;
import com.sgbiblioteca.modelo.Estudiantes;
import com.sgbiblioteca.modelo.Libros;
import com.sgbiblioteca.modelo.Prestamos;

public class PrestamosPanel extends JPanel {

    public JComboBox<String> cbEstudiantes, cbLibros;
    public JButton btnPrestar, btnDevolver;

    public PrestamosPanel() {

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTitulo = new JLabel("Registro de Préstamos y Devoluciones");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel panelTitulo = new JPanel();
        panelTitulo.add(lblTitulo);

        JPanel formulario = new JPanel(new GridLayout(0, 2, 5, 5));
        formulario.setBorder(BorderFactory.createTitledBorder("Seleccione"));

        cbEstudiantes = new JComboBox<>();
        cbEstudiantes.setPreferredSize(new Dimension(150, 25));

        cbLibros = new JComboBox<>();
        cbLibros.setPreferredSize(new Dimension(150, 25));

        cargarDatos();

        formulario.add(new JLabel("Estudiante:"));
        formulario.add(cbEstudiantes);

        formulario.add(new JLabel("Libro:"));
        formulario.add(cbLibros);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnPrestar = new JButton("Registrar Préstamo");
        btnDevolver = new JButton("Registrar Devolución");

        panelBotones.add(btnPrestar);
        panelBotones.add(btnDevolver);

        btnPrestar.addActionListener(e -> registrarPrestamo());

        add(panelTitulo, BorderLayout.NORTH);
        add(formulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatos() {
        EstudianteDAO estDAO = new EstudianteDAO();
        LibroDAO libroDAO = new LibroDAO();

        for (Estudiantes e : estDAO.readAll()) {
            cbEstudiantes.addItem(e.getNombre());
        }

        for (Libros l : libroDAO.readAll()) {
            cbLibros.addItem(l.getTitulo());
        }
    }

    private void registrarPrestamo() {
        PrestamoDAO dao = new PrestamoDAO();

        Prestamos p = new Prestamos(
                0,
                cbEstudiantes.getSelectedIndex() + 1,
                cbLibros.getSelectedIndex() + 1,
                LocalDate.now(),
                LocalDate.now().plusDays(7),
                false
        );

        if (dao.registrarPrestamo(p)) {
            JOptionPane.showMessageDialog(this, "Préstamo registrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            cbEstudiantes.setSelectedIndex(0);
            cbLibros.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
}
