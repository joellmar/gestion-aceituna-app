package com.joselumartos.gestionaceituna.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "partes_recogida")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
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

    @Lob
    @Column(
            name = "observaciones",
            length = 500
    )
    private String observaciones;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "almazara_id")
    private Almazara almazara;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "finca_id")
    private Finca finca;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "cuadrilla_id")
    private Cuadrilla cuadrilla;
}
