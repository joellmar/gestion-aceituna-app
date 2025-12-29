package com.joselumartos.gestionaceituna.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cuadrillas")
public class Cuadrilla {

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
            name = "responsable",
            length = 100,
            nullable = false
    )
    private String responsable;

    @Column(name = "numero_maximo_trabajadores")
    private int numeroMaximoTrabajadores;

    @Column(name = "activa")
    private boolean activa;

    @Transient
    private List<ParteRecogida> partesRecogida;

    @Transient
    private List<Finca> fincas;

    @Transient
    private List<Trabajador> trabajadores;
}
