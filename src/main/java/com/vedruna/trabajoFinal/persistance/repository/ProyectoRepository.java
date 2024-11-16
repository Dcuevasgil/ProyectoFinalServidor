package com.vedruna.trabajoFinal.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vedruna.trabajoFinal.persistance.models.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    @Query("SELECT p FROM Proyecto p WHERE p.nombre_proyecto LIKE %:palabraClave% OR p.descripcion_proyecto LIKE %:palabraClave%")
    List<Proyecto> findByKeyWord(@Param("palabraClave") String palabraClave);
    
    @Query("SELECT p FROM Proyecto p JOIN p.tecnologias t WHERE t.nombre_tecnologia = :tecnologia")
    List<Proyecto> findByTecnologia(@Param("tecnologia") String tecnologia);
}
