package com.vedruna.trabajoFinal.services;

import java.util.List;

import com.vedruna.trabajoFinal.persistance.models.Tecnologia;

public interface TecnologiaServiceI {
    Tecnologia insertarTecnologiaProyecto(Tecnologia tecnologia);
    void eliminarTecnologiaProyectoActual(Integer id);
    List<Tecnologia> obtenerTodasLasTecnologiasProyectos();
    void asociarTecnologia(Integer tecnologiaId, Integer proyectoId);
}
