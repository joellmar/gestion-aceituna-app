package com.joselumartos.gestionaceituna.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cuadrillas")
@NoArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "cuadrilla")
    private List<ParteRecogida> partesRecogida;

    @ManyToMany
    private List<Finca> fincas;

    @ManyToMany
    private List<Trabajador> trabajadores;
}