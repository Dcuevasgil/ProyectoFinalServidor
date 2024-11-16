package com.vedruna.trabajoFinal.DTO;

import java.util.ArrayList;

import com.vedruna.trabajoFinal.persistance.models.Desarrollador;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearDesarrolladorDTO {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String urlLinkedin;
    private String urlGithub;
    private String email_desarrollador;
    private ArrayList<Integer> proyectos;

    public CrearDesarrolladorDTO(Desarrollador desarrollador){
        this.id = desarrollador.getId_desarrollador();
        this.nombre = desarrollador.getNombre_desarrollador();
        this.apellido = desarrollador.getApellido_desarrollador();
        this.email = desarrollador.getEmail();
        this.urlLinkedin = desarrollador.getUrl_linkedin();
        this.urlGithub = desarrollador.getUrl_github();
        this.email_desarrollador = desarrollador.getEmail_desarrollador();
        this.proyectos = new ArrayList<>();
    }
}
