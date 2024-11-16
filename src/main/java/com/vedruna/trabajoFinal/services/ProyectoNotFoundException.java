package com.vedruna.trabajoFinal.services;

public class ProyectoNotFoundException extends RuntimeException {

    
    public ProyectoNotFoundException(String mensaje) {
        super(mensaje);  
    }

    
    public ProyectoNotFoundException(String mensaje, Throwable causa) {
        super(mensaje, causa);  
    }
}

