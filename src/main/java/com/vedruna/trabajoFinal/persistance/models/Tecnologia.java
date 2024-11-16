package com.vedruna.trabajoFinal.persistance.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "technologies")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tech_id")
    private Integer id_tecnologia;

    @Column(name = "tech_name")
    @NotBlank(message = "El nombre de la tecnologia no puede estar vacío ni ser nulo")
    private String nombre_tecnologia;

    @ManyToMany
    @JoinTable(name = "technologies_used_in_projects", joinColumns = @JoinColumn(name = "technologies_tech_id", referencedColumnName = "tech_id"), inverseJoinColumns = @JoinColumn(name = "projects_project_id", referencedColumnName = "project_id"))
    private List<Proyecto> proyectos;
}
