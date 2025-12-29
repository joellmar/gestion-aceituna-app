package com.joselumartos.gestionaceituna.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "partes_recogida")
public class ParteRecogida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(
            name = "fecha",
            nullable = false
    )
    private LocalDate fecha;

    @Column(
            name = "kilos_recogidos",
            precision = 2
    )
    private double kilosRecogidos;

    @Column(
            name = "rendimiento_estimado",
            precision = 2
    )
    private double rendimientoEstimado;

    @Column(
            name = "observaciones",
            length = 500
    )
    private String observaciones;

    @Transient
    private Almazara almazara;

    @Transient
    private Finca finca;

    @Transient
    private Cuadrilla cuadrilla;
}
