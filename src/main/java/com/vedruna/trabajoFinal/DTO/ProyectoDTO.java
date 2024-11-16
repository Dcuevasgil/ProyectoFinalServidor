package com.vedruna.trabajoFinal.DTO;

import java.util.Set;

import com.vedruna.trabajoFinal.persistance.models.Desarrollador;
import com.vedruna.trabajoFinal.persistance.models.Estado_proyecto;
import com.vedruna.trabajoFinal.persistance.models.Proyecto;
import com.vedruna.trabajoFinal.persistance.models.Tecnologia;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProyectoDTO {
    private int id;

    @NotNull(message = "El nombre del proyecto no puede ser nulo")
    @NotEmpty(message = "El nombre del proyecto no puede estar vacío")
    @Size(min = 5, max = 70, message = "El nombre del proyecto no debe tener menos de 5 caracteres ni más de 70")
    private String nombre;

    @NotNull(message = "La descripcion del proyecto no puede ser nulo")
    @NotEmpty(message = "La descripcion del proyecto no puede estar vacío")
    @Size(min = 5, max = 70, message = "La descripcion del proyecto no debe tener menos de 5 caracteres ni más de 70")
    private String descripcion;

    @NotNull(message = "La fecha de inicio del proyecto no puede ser nula")
    @NotEmpty(message = "La fecha de inicio del proyecto no puede estar vacía")
    @Size(min = 5, max = 70, message = "La fecha de inicio del proyecto no debe tener menos de 5 caracteres ni más de 70")
    private String fecha_inicio;

    @NotNull(message = "La fecha de fin del proyecto no puede ser nula")
    @NotEmpty(message = "La fecha de fin del proyecto no puede estar vacía")
    @Size(min = 5, max = 70, message = "La fecha de fin del proyecto no debe tener menos de 5 caracteres ni más de 70")
    private String fecha_fin;

    @NotNull(message = "La url del repositorio del proyecto no puede ser nula")
    @NotEmpty(message = "La url del repositorio del proyecto no puede estar vacía")
    @Size(min = 5, max = 70, message = "La url del repositorio del proyecto no debe tener menos de 5 caracteres ni más de 70")
    private String url_repo_proyecto;

    @NotNull(message = "La url del demo del proyecto no puede ser nula")
    @NotEmpty(message = "La url del demo del proyecto no puede estar vacía")
    @Size(min = 5, max = 70, message = "La url del demo del proyecto no debe tener menos de 5 caracteres ni más de 70")
    private String url_demo_proyecto;

    @NotNull(message = "La imagen del proyecto no puede ser nula")
    @NotEmpty(message = "La imagen del proyecto no puede estar vacía")
    @Size(min = 5, max = 70, message = "La imagen del proyecto no debe tener menos de 5 caracteres ni más de 70")
    private String imagen_proyecto;
    private Estado_proyecto estado_proyecto;
    private Set<Tecnologia> tecnologias;
    private Set<Desarrollador> desarrolladores;

    public ProyectoDTO(Proyecto proyecto) {
        this.id = proyecto.getId_proyecto();
        this.nombre = proyecto.getNombre_proyecto();
        this.descripcion = proyecto.getDescripcion_proyecto();
        this.fecha_inicio = proyecto.getFecha_inicio().toString();
        this.fecha_fin = proyecto.getFecha_fin().toString();
        this.url_repo_proyecto = proyecto.getUrl_repo_proyecto();
        this.url_demo_proyecto = proyecto.getUrl_demo_proyecto();
        this.imagen_proyecto = proyecto.getImagen_proyecto();
        this.estado_proyecto = proyecto.getEstado_proyecto();
        this.tecnologias = proyecto.getTecnologias();
        this.desarrolladores = proyecto.getDesarrolladores();
    }
}
