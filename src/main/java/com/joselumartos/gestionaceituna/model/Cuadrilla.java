package com.joselumartos.gestionaceituna.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cuadrillas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Cuadrilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Integer numeroMaximoTrabajadores;

    @Column(name = "activa")
    private Boolean activa;

    @ManyToMany(
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "cuadrillas_fincas",
            joinColumns = @JoinColumn(
                    name = "cuadrilla_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "finca_id"
            )
    )
    private List<Finca> fincas;

    @ManyToMany(mappedBy = "cuadrillas")
    private List<Trabajador> trabajadores;
}