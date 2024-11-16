package com.vedruna.trabajoFinal.services;

public class ProyectoPaginadoNotFoundException extends RuntimeException {

    public ProyectoPaginadoNotFoundException(String mensaje) {
        super(mensaje);  
    }

    
    public ProyectoPaginadoNotFoundException(String mensaje, Throwable causa) {
        super(mensaje, causa);  
    }
}
