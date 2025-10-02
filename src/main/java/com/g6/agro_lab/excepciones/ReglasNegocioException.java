package com.g6.agro_lab.excepciones;

public class ReglasNegocioException extends RuntimeException{

    public ReglasNegocioException(String mensaje) {
        super(mensaje);
    }
}
