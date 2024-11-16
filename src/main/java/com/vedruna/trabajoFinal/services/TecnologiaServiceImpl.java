package com.vedruna.trabajoFinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedruna.trabajoFinal.persistance.models.Proyecto;
import com.vedruna.trabajoFinal.persistance.models.Tecnologia;
import com.vedruna.trabajoFinal.persistance.repository.ProyectoRepository;
import com.vedruna.trabajoFinal.persistance.repository.TecnologiaRepository;

@Service
public class TecnologiaServiceImpl implements TecnologiaServiceI {

    @Autowired
    TecnologiaRepository tecnologiaRepository;
    @Autowired
    ProyectoRepository proyectoRepository;

    @Override
    @Transactional
    public Tecnologia insertarTecnologiaProyecto(Tecnologia tecnologia) {
        return tecnologiaRepository.save(tecnologia);
    }

    @Override
    @Transactional
    public void eliminarTecnologiaProyectoActual(Integer id) {
        if (tecnologiaRepository.existsById(id)) {
            tecnologiaRepository.deleteById(id);
        } 
        throw new IllegalArgumentException("La tecnología con el ID especificado no existe.");
    }

    @Override
    public List<Tecnologia> obtenerTodasLasTecnologiasProyectos() {
        return tecnologiaRepository.findAll();
    }

    @Override
    @Transactional
    public void asociarTecnologia(Integer tecnologiaId, Integer proyectoId) {
        Optional<Tecnologia> tecnologiaOpt = tecnologiaRepository.findById(tecnologiaId);
        Optional<Proyecto> proyectoOpt = proyectoRepository.findById(proyectoId);

        if (tecnologiaOpt.isPresent() && proyectoOpt.isPresent()) {
            Proyecto proyecto = proyectoOpt.get();
            Tecnologia tecnologia = tecnologiaOpt.get();

            proyecto.getTecnologias().add(tecnologia);
            proyectoRepository.save(proyecto);
        }
        throw new IllegalArgumentException("Proyecto o tecnología no encontrados con los IDs especificados.");
    }
}
