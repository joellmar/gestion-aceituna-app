package com.joselumartos.gestionaceituna.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "almazaras")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Almazara {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",
            length = 100,
            nullable = false,
            unique = true
    )
    private String nombre;

    @Column(
            name = "direccion",
            length = 100
    )
    private String direccion;

    @Column(
            name = "telefono",
            length = 9
    )
    private String telefono;

    @Column(name = "capacidad_toneladas_diarias")
    private Integer capacidadToneladasDiarias;
}
