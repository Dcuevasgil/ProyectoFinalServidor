package com.vedruna.trabajoFinal.services;

public class EstadoProyectoInvalidoException extends RuntimeException {
    public EstadoProyectoInvalidoException(String message) {
        super(message);
    }

    public EstadoProyectoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
