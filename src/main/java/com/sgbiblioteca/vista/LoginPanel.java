package com.sgbiblioteca.vista;

import javax.swing.*;
import java.awt.*;
import com.sgbiblioteca.dao.UsuarioDAO;
import com.sgbiblioteca.modelo.Usuarios;

public class LoginPanel extends JPanel {

    public JTextField txtUsuario;
    public JPasswordField txtClave;
    public JButton btnIngresar;

    public LoginPanel() {

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTitulo = new JLabel("Autenticación de Usuario");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel panelTitulo = new JPanel();
        panelTitulo.add(lblTitulo);

        JPanel formulario = new JPanel(new GridLayout(0, 2, 5, 5));
        formulario.setBorder(BorderFactory.createTitledBorder("Ingrese sus datos"));

        txtUsuario = new JTextField();
        txtUsuario.setPreferredSize(new Dimension(150, 25));

        txtClave = new JPasswordField();
        txtClave.setPreferredSize(new Dimension(150, 25));

        formulario.add(new JLabel("Usuario:"));
        formulario.add(txtUsuario);

        formulario.add(new JLabel("Clave:"));
        formulario.add(txtClave);

        JPanel panelBoton = new JPanel();
        btnIngresar = new JButton("Ingresar");
        panelBoton.add(btnIngresar);

        btnIngresar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String clave = new String(txtClave.getPassword());

            UsuarioDAO dao = new UsuarioDAO();
            Usuarios u = dao.autenticar(usuario, clave);

            if (u != null) {
                JOptionPane.showMessageDialog(this, "Ingreso exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o clave incorrectos", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        });

        add(panelTitulo, BorderLayout.NORTH);
        add(formulario, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }
}
