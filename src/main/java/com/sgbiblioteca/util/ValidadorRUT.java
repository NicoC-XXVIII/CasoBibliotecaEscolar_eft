package com.sgbiblioteca.util;

import com.sgbiblioteca.excepciones.RutInvalidoException;

public class ValidadorRUT {

    private static final String RUT_REGEX = "^[0-9]+-[0-9kK]$";

    public static void validar(String rut) throws RutInvalidoException {
        if (rut == null || !rut.matches(RUT_REGEX)) {
            throw new RutInvalidoException("Formato de RUT no válido");
        }
    }
}
