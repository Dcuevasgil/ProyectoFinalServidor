package com.vedruna.trabajoFinal.DTO;

import java.util.ArrayList;

import com.vedruna.trabajoFinal.persistance.models.Tecnologia;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearTecnologiaDTO {
    private int id;
    private String nombre;
    private ArrayList<Integer> proyectos;

    public CrearTecnologiaDTO(Tecnologia tecnologia) {
        this.id = tecnologia.getId_tecnologia();
        this.nombre = tecnologia.getNombre_tecnologia();
        this.proyectos = new ArrayList<>(); 
    }
    
}
