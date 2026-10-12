package com.sgbiblioteca.modelo;

import com.sgbiblioteca.excepciones.RutInvalidoException;
import com.sgbiblioteca.interfaces.*;
import com.sgbiblioteca.util.ValidadorRUT;

public class Usuarios implements Identificable, Registrable, Validable {

    private int id;
    private String nombre;
    private String rut;
    private String correo;
    private String contrasenia;
    private String rol;

    public Usuarios() {}

    public Usuarios(int id, String nombre, String rut, String correo,
                    String contrasenia, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    @Override
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    @Override
    public void validar() throws RutInvalidoException {
        ValidadorRUT.validar(rut);
    }

    @Override
    public String mostrarResumen() {
        return id + " - " + nombre + " (" + rol + ")";
    }

    @Override
    public String toString() {
        return mostrarResumen();
    }
}
