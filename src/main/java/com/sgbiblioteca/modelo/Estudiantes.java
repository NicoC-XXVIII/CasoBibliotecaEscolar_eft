package com.sgbiblioteca.modelo;

import com.sgbiblioteca.excepciones.RutInvalidoException;
import com.sgbiblioteca.interfaces.Identificable;
import com.sgbiblioteca.interfaces.Registrable;
import com.sgbiblioteca.interfaces.Validable;
import com.sgbiblioteca.util.ValidadorRUT;

public class Estudiantes implements Identificable, Registrable, Validable {

    private int id;
    private String nombre;
    private String rut;
    private String curso;
    private String correo;

    public Estudiantes() {}

    public Estudiantes(int id, String nombre, String rut, String curso,
                       String correo) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.curso = curso;
        this.correo = correo;
    }

    @Override
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    @Override
    public void validar() throws RutInvalidoException {
        ValidadorRUT.validar(rut);
    }

    @Override
    public String mostrarResumen() {
        return id + " - " + nombre + " - " + curso;
    }

    @Override
    public String toString() {
        return mostrarResumen();
    }
}
