package com.sgbiblioteca.controlador;

import com.sgbiblioteca.dao.PrestamoDAO;
import com.sgbiblioteca.dao.LibroDAO;
import com.sgbiblioteca.controlador.HiloPrestamo;
import com.sgbiblioteca.modelo.Prestamos;

public class PrestamoControlador {

    private PrestamoDAO prestamoDAO;
    private LibroDAO libroDAO;

    public PrestamoControlador() {
        prestamoDAO = new PrestamoDAO();
        libroDAO = new LibroDAO();
    }

    public void registrarPrestamoAsync(Prestamos p) {
        HiloPrestamo hilo = new HiloPrestamo(p, prestamoDAO, libroDAO);
        hilo.start();
    }
}
