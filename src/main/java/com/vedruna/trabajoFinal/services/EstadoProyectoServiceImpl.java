package com.vedruna.trabajoFinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.trabajoFinal.persistance.models.Estado_proyecto;
import com.vedruna.trabajoFinal.persistance.repository.EstadoProyectoRepository;

@Service
public class EstadoProyectoServiceImpl implements EstadoProyectoServiceI {
    
    @Autowired
    EstadoProyectoRepository estadoProyectoRepository;

    @Override
    public Optional<Estado_proyecto> obtenerEstadoPorId(Integer id) {
        return estadoProyectoRepository.findById(id);
    }

}
