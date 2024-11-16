package com.vedruna.trabajoFinal.services;

import com.vedruna.trabajoFinal.persistance.models.Estado_proyecto;
import com.vedruna.trabajoFinal.persistance.models.Proyecto;
import com.vedruna.trabajoFinal.services.enums.EstadoProyecto;
import com.vedruna.trabajoFinal.persistance.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServiceImpl implements ProyectoServiceI {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> obtenerProyectosPaginados(int page, int pageSize) {
        try {
            Pageable pageable = PageRequest.of(page, pageSize);
            return proyectoRepository.findAll(pageable).getContent();
        } catch (Exception e) {
            throw new ProyectoPaginadoNotFoundException("Error al obtener proyectos paginados", e);
        }
    }

    @Override
    public List<Proyecto> obtenerProyectosPorPalabraClave(String palabraClave) {
        try {
            List<Proyecto> proyectos = proyectoRepository.findByKeyWord(palabraClave);
            if (proyectos.isEmpty()) {
                throw new ProyectoNotFoundException("No se encontraron proyectos con la palabra clave: " + palabraClave);
            }
            return proyectos;
        } catch (Exception e) {
            throw new ProyectoNotFoundException("Error al obtener proyectos por palabra clave", e);
        }
    }

    @Override
    public Proyecto obtenerProyectoPorId(Integer id) {
        try {
            Optional<Proyecto> proyecto = proyectoRepository.findById(id);
            return proyecto.orElseThrow(() -> new ProyectoNotFoundException("Proyecto no encontrado con id: " + id));
        } catch (Exception e) {
            throw new ProyectoNotFoundException("Error al obtener proyecto por id", e);
        }
    }

    @Override
    public Proyecto insertarProyecto(Proyecto proyecto) {
        // Validación de entrada
        if (proyecto == null || proyecto.getNombre_proyecto() == null || proyecto.getDescripcion_proyecto() == null) {
            throw new IllegalArgumentException("El proyecto o sus campos no pueden ser nulos.");
        }
        try {
            return proyectoRepository.save(proyecto);
        } catch (Exception e) {
            throw new InsercionProyectoNotFoundException("Error al insertar proyecto", e);
        }
    }

    @Override
    public Proyecto actualizarProyecto(Integer id, Proyecto proyecto) {
        try {
            Optional<Proyecto> proyectoExistente = proyectoRepository.findById(id);
            if (proyectoExistente.isPresent()) {
                Proyecto proyectoActualizado = proyectoExistente.get();
                proyectoActualizado.setNombre_proyecto(proyecto.getNombre_proyecto());
                proyectoActualizado.setDescripcion_proyecto(proyecto.getDescripcion_proyecto());
                proyectoActualizado.setEstado_proyecto(proyecto.getEstado_proyecto());
                return proyectoRepository.save(proyectoActualizado);
            } else {
                throw new ProyectoNotFoundException("Proyecto no encontrado con id: " + id);
            }
        } catch (Exception e) {
            throw new ActualizarProyectoException("Error al actualizar proyecto", e);
        }
    }

    @Override
    public boolean eliminarProyecto(Integer id) {
        try {
            if (proyectoRepository.existsById(id)) {
                proyectoRepository.deleteById(id);
                return true;
            } else {
                throw new ProyectoNotFoundException("Proyecto no encontrado con id: " + id);
            }
        } catch (Exception e) {
            throw new EliminarProyectoNotFoundException("Error al eliminar proyecto", e);
        }
    }

    @Override
    public boolean cambiarEstado(Integer id, String nuevoEstado) {
        try {
            if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
                throw new EstadoProyectoInvalidoException("El nuevo estado no puede ser nulo o vacío.");
            }

            // Convertir el String a un valor del enum EstadoProyecto
            Estado_proyecto estado = Estado_proyecto.valueOf(nuevoEstado.toUpperCase().replace(" ", "_"));

            Optional<Proyecto> proyectoExistente = proyectoRepository.findById(id);
            if (proyectoExistente.isPresent()) {
                Proyecto proyecto = proyectoExistente.get();
                // Asignar el estado en la relación
                proyecto.setEstado_proyecto(estado); // Asegúrate de que el campo en Proyecto sea del tipo EstadoProyecto
                proyectoRepository.save(proyecto);
                return true;
            } else {
                throw new ProyectoNotFoundException("Proyecto no encontrado con id: " + id);
            }
        } catch (IllegalArgumentException e) {
            throw new EstadoProyectoInvalidoException("Error en el estado proporcionado: " + e.getMessage(), e);
        } catch (ProyectoNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ErroresGeneralizadosException("Error al cambiar el estado del proyecto con id: " + id, e);
        }
    }

}