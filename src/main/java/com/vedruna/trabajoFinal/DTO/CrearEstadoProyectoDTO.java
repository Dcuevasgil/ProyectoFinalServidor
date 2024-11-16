package com.vedruna.trabajoFinal.DTO;

import java.util.ArrayList;

import com.vedruna.trabajoFinal.persistance.models.Estado_proyecto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearEstadoProyectoDTO {
    private int id_estado;
    private String nombre_estado;
    private ArrayList<Integer> proyectos;

    public CrearEstadoProyectoDTO(Estado_proyecto estado_proyecto) {
        this.id_estado = estado_proyecto.getId_estado_proyecto();
        this.nombre_estado = estado_proyecto.getNombre_estado_proyecto();
        this.proyectos = new ArrayList<>(); 
    }
}
