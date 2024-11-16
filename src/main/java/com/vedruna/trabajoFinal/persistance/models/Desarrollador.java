package com.vedruna.trabajoFinal.persistance.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "developers")
public class Desarrollador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private Integer id_desarrollador;

    @Column(name = "dev_name")
    @NotBlank(message = "El nombre del desarrollador no puede estar vacío ni ser nulo")
    private String nombre_desarrollador;

    @Column(name = "dev_surname")
    @NotBlank(message = "El apellido del desarrollador no puede estar vacío ni ser nulo")
    private String apellido_desarrollador;

    @Column(name = "email")
    @Email(message = "El email no es válido")
    @NotBlank(message = "El email no puede estar vacío ni ser nulo")
    private String email;

    @Column(name = "linkedin_url")
    @NotBlank(message = "La url de linkedin del desarrollador no puede estar vacío ni ser nulo")
    private String url_linkedin;

    @Column(name = "github_url")
    @NotBlank(message = "La url de github del desarrollador no puede estar vacío ni ser nulo")
    private String url_github;

    @Column(name = "dev_email")
    @Email(message = "El email no es válido")
    @NotBlank(message = "El email del desarrollador no puede estar vacío ni ser nulo")
    private String email_desarrollador;

    @ManyToMany(mappedBy = "developers")
    private List<Proyecto> proyectos;

}
