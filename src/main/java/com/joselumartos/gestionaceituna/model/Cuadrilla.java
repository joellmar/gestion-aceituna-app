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

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "cuadrillas_fincas",
            joinColumns = @JoinColumn(
                    name = "cuadrilla_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "finca_id",
                    referencedColumnName = "id"
            )
    )
    private List<Finca> fincas;

    @ManyToMany(mappedBy = "cuadrillas")
    private List<Trabajador> trabajadores;
}