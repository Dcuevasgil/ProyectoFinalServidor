package com.vedruna.trabajoFinal.DTO;

import java.util.ArrayList;

import com.vedruna.trabajoFinal.persistance.models.Tecnologia;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TecnologiaDTO {
    private int id;

    @NotNull(message = "El nombre de la tecnologia no puede ser nulo")
    @NotEmpty(message = "El nombre de la tecnologia no puede estar vacío")
    @Size(min = 5, max = 30, message = "El nombre de la tecnologia no debe tener menos de 5 caracteres ni más de 30")
    private String nombre;
    private ArrayList<Integer> proyectos;

    public TecnologiaDTO(Tecnologia tecnologia) {
        this.id = tecnologia.getId_tecnologia();
        this.nombre = tecnologia.getNombre_tecnologia();
        this.proyectos = new ArrayList<>();
    }
}
