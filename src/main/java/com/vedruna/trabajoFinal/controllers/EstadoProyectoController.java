package com.vedruna.trabajoFinal.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.trabajoFinal.persistance.models.Proyecto;
import com.vedruna.trabajoFinal.services.ProyectoServiceI;

@RestController
@RequestMapping("/api/v1/projects")
public class EstadoProyectoController {

    @Autowired
    ProyectoServiceI proyectoService;


    @PutMapping("/totesting/{id}")
    public ResponseEntity<GenericResponseDTO<String>> cambiarAEstadoTesting(@PathVariable("id") Integer id) {
        try {
            Optional<Proyecto> proyectoOpt = proyectoService.obtenerProyectoPorId(id);
            if (proyectoOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponseDTO<>("Proyecto no encontrado"));
            }

            Proyecto proyecto = proyectoOpt.get();
            if (!proyecto.getEstado_proyecto().equals("Development")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponseDTO<>("El proyecto no está en estado 'Development'"));
            }

            proyecto.setEstado_proyecto("Testing");
            proyectoService.actualizarProyecto(id, proyecto);
            return ResponseEntity.ok(new GenericResponseDTO<>("Proyecto cambiado a Testing"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponseDTO<>("Error al cambiar el proyecto a Testing"));
        }
    }

    @PutMapping("/toprod/{id}")
    public ResponseEntity<GenericResponseDTO<String>> cambiarAEstadoProduction(@PathVariable("id") Integer id) {
        try {
            Optional<Proyecto> proyectoOpt = proyectoService.obtenerProyectoPorId(id);
            if (proyectoOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponseDTO<>("Proyecto no encontrado"));
            }

            Proyecto proyecto = proyectoOpt.get();
            if (!proyecto.getEstado_proyecto().equals("Testing")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponseDTO<>("El proyecto no está en estado 'Testing'"));
            }

            proyecto.setEstado_proyecto("Production");
            proyectoService.actualizarProyecto(id, proyecto);
            return ResponseEntity.ok(new GenericResponseDTO<>("Proyecto cambiado a Production"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponseDTO<>("Error al cambiar el proyecto a Production"));
        }
    }
}

