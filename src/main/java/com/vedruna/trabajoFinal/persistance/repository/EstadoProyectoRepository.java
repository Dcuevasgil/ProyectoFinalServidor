package com.vedruna.trabajoFinal.persistance.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.trabajoFinal.persistance.models.Estado_proyecto;

@Repository
public interface EstadoProyectoRepository extends JpaRepository<Estado_proyecto, Integer> {
    Estado_proyecto findByNombreEstadoProyecto(String nombreEstadoProyecto);
}
