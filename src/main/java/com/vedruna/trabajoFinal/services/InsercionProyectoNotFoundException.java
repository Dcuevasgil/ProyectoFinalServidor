package com.vedruna.trabajoFinal.services;

public class InsercionProyectoNotFoundException extends RuntimeException{
    
    public InsercionProyectoNotFoundException(String message) {
        super(message);
    }

    public InsercionProyectoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
