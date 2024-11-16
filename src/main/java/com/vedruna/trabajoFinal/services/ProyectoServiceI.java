package com.vedruna.trabajoFinal.services;

import java.util.List;

import com.vedruna.trabajoFinal.persistance.models.Proyecto;

public interface ProyectoServiceI {
    List<Proyecto> obtenerProyectosPaginados(int page, int pageSize);
    List<Proyecto> obtenerProyectosPorPalabraClave(String palabraClave);
    Proyecto obtenerProyectoPorId(Integer id);
    Proyecto insertarProyecto(Proyecto proyecto);
    Proyecto actualizarProyecto(Integer id, Proyecto proyecto);
    boolean eliminarProyecto(Integer id);
    boolean cambiarEstado(Integer id, String nuevoEstado);
}
