package com.vedruna.trabajoFinal.persistance.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.trabajoFinal.persistance.models.Tecnologia;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Integer> {
    
}
