package com.vedruna.trabajoFinal.persistance.models;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer id_proyecto;

    @Column(name = "project_name")
    private String nombre_proyecto;

    @Column(name = "description")
    private String descripcion_proyecto;

    @Column(name = "start_date")
    private Date fecha_inicio;

    @Column(name = "end_date")
    private Date fecha_fin;

    @Size(max = 45)
    @Column(name = "repository_url")
    private String url_repo_proyecto;

    @Size(max = 45)
    @Column(name = "demo_url")
    private String url_demo_proyecto;

    @Column(name = "picture")
    private String imagen_proyecto;

    @ManyToOne
    @JoinColumn(name = "status_status_id", referencedColumnName = "status_id")
    private Estado_proyecto estado_proyecto;

    @ManyToMany
    @JoinTable(name = "technologies_used_in_projects", joinColumns = @JoinColumn(name = "projects_project_id"), inverseJoinColumns = @JoinColumn(name = "technologies_tech_id"))
    private Set<Tecnologia> tecnologias;

}
