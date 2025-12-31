package com.joselumartos.gestionaceituna.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "trabajadores")
@NoArgsConstructor
@Getter
@Setter
public class Trabajador {

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
            name = "dni",
            length = 9,
            nullable = false,
            unique = true
    )
    private String dni;

    @Column(
            name = "telefono",
            length = 9
    )
    private String telefono;

    @Column(
            name = "categoria_profesional",
            length = 50
    )
    private String categoriaProfesional;

    @Column(name = "activo")
    private boolean activo;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "trabajadores_cuadrillas",
            joinColumns = @JoinColumn(
                    name = "trabajador_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "cuadrilla_id",
                    referencedColumnName = "id"
            )
    )
    private List<Cuadrilla> cuadrillas;
}
