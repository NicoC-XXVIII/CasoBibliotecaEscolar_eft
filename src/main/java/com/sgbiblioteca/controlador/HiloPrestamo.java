package com.sgbiblioteca.controlador;

import com.sgbiblioteca.dao.PrestamoDAO;
import com.sgbiblioteca.dao.LibroDAO;
import com.sgbiblioteca.modelo.Prestamos;

public class HiloPrestamo extends Thread {

    private Prestamos prestamo;
    private PrestamoDAO prestamoDAO;
    private LibroDAO libroDAO;

    public HiloPrestamo(Prestamos prestamo, PrestamoDAO prestamoDAO, LibroDAO libroDAO) {
        this.prestamo = prestamo;
        this.prestamoDAO = prestamoDAO;
        this.libroDAO = libroDAO;
    }

    @Override
    public void run() {
        System.out.println("Hilo iniciado: registrando préstamo...");

        // Registrar préstamo
        boolean ok = prestamoDAO.registrarPrestamo(prestamo);

        if (ok) {
            System.out.println("Préstamo registrado correctamente.");

            // Actualizar stock de forma sincronizada
            synchronized (libroDAO) {
                int stockActual = libroDAO.obtenerStock(prestamo.getIdLibro());
                libroDAO.actualizarStock(prestamo.getIdLibro(), stockActual - 1);
            }

            System.out.println("Stock actualizado.");
        } else {
            System.out.println("Error al registrar el préstamo.");
        }
    }
}
