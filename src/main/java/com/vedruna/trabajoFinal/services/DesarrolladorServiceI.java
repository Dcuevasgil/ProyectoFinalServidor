package com.vedruna.trabajoFinal.services;

import java.util.List;

import com.vedruna.trabajoFinal.persistance.models.Desarrollador;

public interface DesarrolladorServiceI {
    Desarrollador insertarDesarrollador(Desarrollador desarrollador);
    boolean eliminarDesarrollador(Integer id);
    boolean asignarProyecto(Integer desarrollador_id, Integer proyectoId);
    List<Desarrollador> obtenerTodosLosDesarrolladores();
}
