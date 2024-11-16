package com.vedruna.trabajoFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.trabajoFinal.DTO.DesarrolladorDTO; // DTO de creación
import com.vedruna.trabajoFinal.persistance.models.Desarrollador;
import com.vedruna.trabajoFinal.services.DesarrolladorServiceI;

@RestController
@RequestMapping("/api/v1/developers")
public class DesarrolladorController {

    @Autowired
    DesarrolladorServiceI desarrolladorService;

    @PostMapping
    public ResponseEntity<GenericResponseDTO<Desarrollador>> insertarDesarrollador(@RequestBody DesarrolladorDTO desarrolladorDTO) {
        try {
            Desarrollador nuevoDesarrollador = desarrolladorService.insertarDesarrollador(desarrolladorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponseDTO<>("Desarrollador creado", nuevoDesarrollador));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponseDTO<>("Error al crear desarrollador", null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDTO<String>> eliminarDesarrollador(@PathVariable("id") Integer id) {
        try {
            if (desarrolladorService.eliminarDesarrollador(id)) {
                return ResponseEntity.ok(new GenericResponseDTO<>("Desarrollador eliminado", null));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponseDTO<>("Desarrollador no encontrado", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponseDTO<>("Error al eliminar desarrollador", null));
        }
    }

    @PostMapping("/worked/{id}")
    public ResponseEntity<GenericResponseDTO<Boolean>> asignarTrabajoEnProyecto(
            @PathVariable("id") Integer idProyecto, 
            @RequestBody DesarrolladorDTO desarrolladorDTO) { // Aquí también DTO
        try {
            boolean asignado = desarrolladorService.asignarProyecto(desarrolladorDTO.getId_desarrollador(), idProyecto);
            return ResponseEntity.ok(new GenericResponseDTO<>("Trabajo asignado a proyecto", asignado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponseDTO<>("Error al asignar trabajo a proyecto", false));
        }
    }
}
