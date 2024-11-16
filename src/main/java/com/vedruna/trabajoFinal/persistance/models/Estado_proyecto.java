package com.vedruna.trabajoFinal.persistance.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "status")
public class Estado_proyecto {
    @Id
    @Column(name = "status_id")
    private Integer id_estado_proyecto;

    @Column(name = "status_name")
    @NotBlank(message = "El nombre del estado no puede estar vacío ni ser nulo")
    private String nombre_estado_proyecto;

    @OneToMany(mappedBy = "estado_proyecto")
    private Set<Proyecto> proyectos;

}