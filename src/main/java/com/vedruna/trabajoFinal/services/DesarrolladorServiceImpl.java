package com.vedruna.trabajoFinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedruna.trabajoFinal.persistance.models.Desarrollador;
import com.vedruna.trabajoFinal.persistance.models.Proyecto;
import com.vedruna.trabajoFinal.persistance.repository.DesarrolladorRepository;
import com.vedruna.trabajoFinal.persistance.repository.ProyectoRepository;

@Service
public class DesarrolladorServiceImpl implements DesarrolladorServiceI {

    @Autowired
    DesarrolladorRepository desarrolladorRepository;
    @Autowired
    ProyectoRepository proyectoRepository;

    @Override
    @Transactional
    public Desarrollador insertarDesarrollador(Desarrollador desarrollador) {
        return desarrolladorRepository.save(desarrollador);
    }

    @Override
    @Transactional
    public boolean eliminarDesarrollador(Integer id) {
        Optional<Desarrollador> desarrolladorOpt = desarrolladorRepository.findById(id);

        if(desarrolladorOpt.isPresent()) {
            desarrolladorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean asignarProyecto(Integer desarrollador_id, Integer proyectoId) {
        Optional<Desarrollador> desarrolladorOpt = desarrolladorRepository.findById(desarrollador_id);
        Optional<Proyecto> proyectoOpt = proyectoRepository.findById(proyectoId);

        if(desarrolladorOpt.isPresent() && proyectoOpt.isPresent()) {
            Desarrollador desarrollador = desarrolladorOpt.get();
            Proyecto proyecto = proyectoOpt.get();
            desarrollador.getProyectos().add(proyecto);
            desarrolladorRepository.save(desarrollador);
            return true;
        }
        return false;
    }

    @Override
    public List<Desarrollador> obtenerTodosLosDesarrolladores() {
        return desarrolladorRepository.findAll();
    }
    
}
