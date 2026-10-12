package com.sgbiblioteca.vista;

import javax.swing.*;
import java.awt.*;
import com.sgbiblioteca.dao.EstudianteDAO;
import com.sgbiblioteca.modelo.Estudiantes;

public class EstudiantesPanel extends JPanel {

    public JTextField txtNombre, txtRut, txtCurso, txtCorreo;
    public JButton btnGuardar, btnActualizar, btnEliminar;

    public EstudiantesPanel() {

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTitulo = new JLabel("Gestión de Estudiantes");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel panelTitulo = new JPanel();
        panelTitulo.add(lblTitulo);

        JPanel formulario = new JPanel(new GridLayout(0, 2, 5, 5));
        formulario.setBorder(BorderFactory.createTitledBorder("Datos del Estudiante"));

        txtNombre = new JTextField();
        txtNombre.setPreferredSize(new Dimension(150, 25));

        txtRut = new JTextField();
        txtRut.setPreferredSize(new Dimension(150, 25));

        txtCurso = new JTextField();
        txtCurso.setPreferredSize(new Dimension(150, 25));

        txtCorreo = new JTextField();
        txtCorreo.setPreferredSize(new Dimension(150, 25));

        formulario.add(new JLabel("Nombre:"));
        formulario.add(txtNombre);

        formulario.add(new JLabel("RUT:"));
        formulario.add(txtRut);

        formulario.add(new JLabel("Curso:"));
        formulario.add(txtCurso);

        formulario.add(new JLabel("Correo:"));
        formulario.add(txtCorreo);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);

        btnGuardar.addActionListener(e -> {
            EstudianteDAO dao = new EstudianteDAO();

            Estudiantes est = new Estudiantes(
                    0,
                    txtNombre.getText(),
                    txtRut.getText(),
                    txtCurso.getText(),
                    txtCorreo.getText()
            );

            if (dao.create(est)) {
                JOptionPane.showMessageDialog(this, "Guardado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panelTitulo, BorderLayout.NORTH);
        add(formulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtRut.setText("");
        txtCurso.setText("");
        txtCorreo.setText("");
    }
}
