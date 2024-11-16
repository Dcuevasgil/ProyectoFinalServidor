package com.vedruna.trabajoFinal.services;

import java.util.Optional;

import com.vedruna.trabajoFinal.persistance.models.Estado_proyecto;

public interface EstadoProyectoServiceI {
    Optional<Estado_proyecto> obtenerEstadoPorId(Integer id);
}
