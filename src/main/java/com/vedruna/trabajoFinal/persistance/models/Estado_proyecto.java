package com.vedruna.trabajoFinal.persistance.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private String nombre_estado_proyecto;

    @OneToMany(mappedBy = "estado_proyecto")
    private List<Proyecto> proyectos;

}
