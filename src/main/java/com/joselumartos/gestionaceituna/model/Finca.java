package com.joselumartos.gestionaceituna.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fincas")
public class Finca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(
            name = "nombre",
            length = 100,
            nullable = false,
            unique = true
    )
    private String nombre;

    @Column(
            name = "propietario",
            length = 100,
            nullable = false
    )
    private String propietario;

    @Column(
            name = "extension_hectareas",
            precision = 2
    )
    private double extensionHectareas;

    @Column(
            name = "variedad_aceituna",
            length = 20
    )
    private String variedadAceituna;

    @Column(name = "activa_campaña")
    private boolean activaCampaña;

    @Transient
    private List<ParteRecogida> partesRecogida;

    @Transient
    private List<Cuadrilla> cuadrillas;
}
