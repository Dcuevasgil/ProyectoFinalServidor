package com.vedruna.trabajoFinal.services;

public class ErroresGeneralizadosException extends RuntimeException {

    public ErroresGeneralizadosException(String message) {
        super(message);
    }

    public ErroresGeneralizadosException(String message, Throwable cause) {
        super(message, cause);
    }
}
