package com.vedruna.trabajoFinal.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.trabajoFinal.persistance.models.Desarrollador;

@Repository
public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Integer> {
    
}
