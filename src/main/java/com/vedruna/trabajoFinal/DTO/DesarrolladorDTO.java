package com.vedruna.trabajoFinal.DTO;

import java.util.List;

import com.vedruna.trabajoFinal.persistance.models.Desarrollador;
import com.vedruna.trabajoFinal.persistance.models.Proyecto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class DesarrolladorDTO {
    private int id_desarrollador;

    @NotNull(message = "El nombre del desarrollador no puede ser nulo")
    @NotEmpty(message = "El nombre del desarrollador no puede estar vacío")
    @Size(min = 5, max = 40, message = "El nombre del desarrollador no debe tener menos de 5 caracteres ni más de 40")
    private String nombre;

    @NotNull(message = "El apellido del desarrollador no puede ser nulo")
    @NotEmpty(message = "El apellido del desarrollador no puede estar vacío")
    @Size(min = 5, max = 40, message = "El apellido del desarrollador no debe tener menos de 5 caracteres ni más de 40")
    private String apellido;

    @NotNull(message = "El email no puede ser nulo")
    @NotEmpty(message = "El email no puede estar vacío")
    @Size(min = 5, max = 255, message = "El email no debe tener menos de 5 caracteres ni más de 255")
    private String email;

    @NotNull(message = "La url de linkedin del desarrollador no puede ser nulo")
    @NotEmpty(message = "La url de linkedin del desarrollador no puede estar vacío")
    @Size(min = 5, max = 255, message = "La url de linkedin no debe tener menos de 5 caracteres ni más de 255")
    private String url_linkedin;

    @NotNull(message = "La url de github del desarrollador no puede ser nulo")
    @NotEmpty(message = "La url de github del desarrollador no puede estar vacío")
    @Size(min = 5, max = 255, message = "La url de github no debe tener menos de 5 caracteres ni más de 255")
    private String url_github;

    @NotNull(message = "El email del desarrollador no puede ser nulo")
    @NotEmpty(message = "El email del desarrollador no puede estar vacío")
    @Size(min = 5, max = 255, message = "El email del desarrollador no debe tener menos de 5 caracteres ni más de 255")
    private String email_desarrollador;
    private List<Integer> proyectos;

    public DesarrolladorDTO(Desarrollador desarrollador) {
        this.id_desarrollador = desarrollador.getId_desarrollador();
        this.nombre = desarrollador.getNombre_desarrollador();
        this.apellido = desarrollador.getApellido_desarrollador();
        this.email = desarrollador.getEmail();
        this.url_linkedin = desarrollador.getUrl_linkedin();
        this.url_github = desarrollador.getUrl_github();
        this.email_desarrollador = desarrollador.getEmail_desarrollador();
        this.proyectos = desarrollador.getProyectos().stream().map(Proyecto::getId_proyecto).toList();
    }
    
}
