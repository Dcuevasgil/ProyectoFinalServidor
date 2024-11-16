package com.vedruna.trabajoFinal.services.enums;

import java.sql.Date;
import java.util.Set;

import com.vedruna.trabajoFinal.persistance.models.Desarrollador;
import com.vedruna.trabajoFinal.persistance.models.Tecnologia;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public enum Estado_proyecto {
    IN_DEVELOPMENT,
    IN_PRODUCTION,
    TESTING;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer id_proyecto;

    @Column(name = "project_name")
    @NotBlank(message = "El nombre del proyecto no puede estar vacío ni ser nulo")
    private String nombre_proyecto;

    @Column(name = "description")
    @NotBlank(message = "La descripcion del proyecto no puede estar vacío ni ser nulo")
    private String descripcion_proyecto;

    @Column(name = "start_date")
    @NotBlank(message = "La fecha de inicio del proyecto no puede estar vacío ni ser nulo")
    private Date fecha_inicio;

    @Column(name = "end_date")
    @NotBlank(message = "La fecha de fin del proyecto no puede estar vacío ni ser nulo")
    private Date fecha_fin;

    @Column(name = "repository_url")
    @NotBlank(message = "La url del repositorio del proyecto no puede estar vacío ni ser nulo")
    private String url_repo_proyecto;

    @Column(name = "demo_url")
    @NotBlank(message = "La url del demo del proyecto no puede estar vacío ni ser nulo")
    private String url_demo_proyecto;

    @Column(name = "picture")
    @NotBlank(message = "La url del demo del proyecto no puede estar vacío ni ser nulo")
    private String imagen_proyecto;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private Estado_proyecto estado_proyecto;

    @ManyToMany
    @JoinTable(name = "technologies_used_in_projects", joinColumns = @JoinColumn(name = "projects_project_id", referencedColumnName = "project_id"), inverseJoinColumns = @JoinColumn(name = "technologies_tech_id", referencedColumnName = "tech_id"))
    private Set<Tecnologia> tecnologias;

    @ManyToMany
    @JoinTable(name = "developers_worked_on_projects", joinColumns = @JoinColumn(name = "projects_project_id", referencedColumnName = "project_id"), inverseJoinColumns = @JoinColumn(name = "developers_dev_id", referencedColumnName = "dev_id"))
    private Set<Desarrollador> desarrolladores;
}