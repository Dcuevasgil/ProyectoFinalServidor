package com.vedruna.trabajoFinal.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.trabajoFinal.DTO.GenericResponseDTO;
import com.vedruna.trabajoFinal.DTO.ProyectoDTO; // DTO de creación
import com.vedruna.trabajoFinal.persistance.models.Proyecto;
import com.vedruna.trabajoFinal.services.ProyectoServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/projects")
public class ProyectoController {

    private final ProyectoServiceI proyectoService;

    @Autowired
    public ProyectoController(ProyectoServiceI proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping
    public ResponseEntity<List<Proyecto>> obtenerProyectosPaginados(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            List<Proyecto> proyectos = proyectoService.obtenerProyectosPaginados(page, pageSize);
            return ResponseEntity.ok(proyectos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<GenericResponseDTO<Proyecto>> insertarProyecto(@Valid @RequestBody ProyectoDTO proyectoDTO) { // DTO de creación
        try {
            Proyecto nuevoProyecto = proyectoService.insertarProyecto(proyectoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponseDTO<>("Proyecto creado correctamente", nuevoProyecto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponseDTO<>("Error al crear el proyecto"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponseDTO<Proyecto>> actualizarProyecto(@PathVariable("id") Integer id, @Valid @RequestBody ProyectoDTO proyectoDTO) { // DTO de creación
        try {
            Proyecto proyectoActualizado = proyectoService.actualizarProyecto(id, proyectoDTO);
            return ResponseEntity.ok(new GenericResponseDTO<>("Proyecto actualizado correctamente", proyectoActualizado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponseDTO<>("Error al actualizar el proyecto"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDTO<String>> eliminarProyecto(@PathVariable("id") Integer id) {
        try {
            proyectoService.eliminarProyecto(id);
            return ResponseEntity.ok(new GenericResponseDTO<>("Proyecto eliminado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponseDTO<>("Error al eliminar el proyecto"));
        }
    }
}

