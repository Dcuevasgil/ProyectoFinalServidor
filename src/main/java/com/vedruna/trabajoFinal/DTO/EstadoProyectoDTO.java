package com.vedruna.trabajoFinal.DTO;

import java.util.ArrayList;

import com.vedruna.trabajoFinal.persistance.models.Estado_proyecto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EstadoProyectoDTO {
    private int id_estado;

    @NotNull(message = "El nombre del estado no puede ser nulo")
    @NotEmpty(message = "El nombre del estado no puede estar vacío")
    @Size(min = 5, max = 30, message = "El nombre del estado no debe tener menos de 5 caracteres ni más de 30")
    private String nombre_estado;
    private ArrayList<Integer> proyectos;

    public EstadoProyectoDTO(Estado_proyecto estado_proyecto) {
        this.id_estado = estado_proyecto.getId_estado_proyecto();
        this.nombre_estado = estado_proyecto.getNombre_estado_proyecto();
        this.proyectos = new ArrayList<>(); 
    }
}
