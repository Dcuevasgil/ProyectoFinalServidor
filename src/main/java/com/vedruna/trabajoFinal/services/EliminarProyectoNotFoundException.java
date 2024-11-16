package com.vedruna.trabajoFinal.services;

public class EliminarProyectoNotFoundException extends RuntimeException {

    public EliminarProyectoNotFoundException(String message) {
        super(message);
    }

    public EliminarProyectoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
