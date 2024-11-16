package com.vedruna.trabajoFinal.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.trabajoFinal.DTO.GenericResponseDTO;
import com.vedruna.trabajoFinal.DTO.CrearTecnologiaDTO; // DTO de creación
import com.vedruna.trabajoFinal.persistance.models.Tecnologia;
import com.vedruna.trabajoFinal.services.TecnologiaServiceI;

@RestController
@RequestMapping("/api/v1/technologies")
public class TecnologiaController {

    private final TecnologiaServiceI tecnologiaService;

    public TecnologiaController(TecnologiaServiceI tecnologiaService) {
        this.tecnologiaService = tecnologiaService;
    }

    @PostMapping
    public ResponseEntity<?> insertarTecnologiaProyecto(@RequestBody TecnologiaDTO tecnologiaDTO) { // Aquí se usa el DTO
        try {
            Tecnologia nuevaTecnologia = tecnologiaService.insertarTecnologiaProyecto(tecnologiaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponseDTO<>("La tecnologia se creó correctamente", nuevaTecnologia));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponseDTO<>("Error al crear tecnología", null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTecnologiaProyectoActual(@PathVariable("id") Integer id) {
        try {
            tecnologiaService.eliminarTecnologiaProyectoActual(id);
            return ResponseEntity.ok(new GenericResponseDTO<>("Tecnología eliminada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponseDTO<>("Error al eliminar tecnología"));
        }
    }
}
