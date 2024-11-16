package com.vedruna.trabajoFinal.DTO;

import java.util.Set;

import com.vedruna.trabajoFinal.persistance.models.Desarrollador;
import com.vedruna.trabajoFinal.persistance.models.Estado_proyecto;
import com.vedruna.trabajoFinal.persistance.models.Proyecto;
import com.vedruna.trabajoFinal.persistance.models.Tecnologia;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearProyectoDTO {
    private int id_proyecto;
    private String nombre_proyecto;
    private String descripcion_proyecto;
    private String fecha_inicio;
    private String fecha_fin;
    private String url_repo_proyecto;
    private String url_demo_proyecto;
    private String imagen_proyecto;
    private Estado_proyecto estado_proyecto;
    private Set<Tecnologia> tecnologias;
    private Set<Desarrollador> desarrolladores;

    public CrearProyectoDTO(Proyecto proyecto) {
        this.id_proyecto = proyecto.getId_proyecto();
        this.nombre_proyecto = proyecto.getNombre_proyecto();
        this.descripcion_proyecto = proyecto.getDescripcion_proyecto();
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
