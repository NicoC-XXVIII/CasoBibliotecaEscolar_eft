package com.sgbiblioteca.modelo;

import com.sgbiblioteca.interfaces.Identificable;
import com.sgbiblioteca.interfaces.Registrable;

public class Categorias implements Identificable, Registrable {

    private int id;
    private String nombre;

    public Categorias() {}

    public Categorias(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String mostrarResumen() {
        return id + " - " + nombre;
    }

    @Override
    public String toString() {
        return mostrarResumen();
    }
}
