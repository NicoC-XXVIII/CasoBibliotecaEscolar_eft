package com.sgbiblioteca;

import com.sgbiblioteca.vista.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {

        System.out.println("Iniciando programa...");

        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);

        // Detectar cierre de ventana
        vp.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.out.println("Programa finalizado");
            }
        });
    }
}
