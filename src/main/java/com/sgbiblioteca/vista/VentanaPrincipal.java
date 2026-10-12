package com.sgbiblioteca.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JTabbedPane tabs;

    public VentanaPrincipal() {

        setTitle("Sistema Biblioteca Escolar");
        setSize(900, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabs = new JTabbedPane();

        // Paneles del sistema
        LoginPanel loginPanel = new LoginPanel();
        LibrosPanel librosPanel = new LibrosPanel();
        EstudiantesPanel estudiantesPanel = new EstudiantesPanel();
        PrestamosPanel prestamosPanel = new PrestamosPanel();


        // Agregar pestañas
        tabs.addTab("Login", loginPanel);
        tabs.addTab("Libros", librosPanel);
        tabs.addTab("Estudiantes", estudiantesPanel);
        tabs.addTab("Préstamos", prestamosPanel);

        add(tabs, BorderLayout.CENTER);
    }
}
