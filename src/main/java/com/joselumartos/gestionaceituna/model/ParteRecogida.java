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
    private Long id;


    @Column(
            name = "fecha",
            nullable = false
    )
    private LocalDate fecha;

    @Column(
            name = "kilos_recogidos",
            precision = 2
    )
    private Double kilosRecogidos;

    @Column(
            name = "rendimiento_estimado",
            precision = 2
    )
    private Double rendimientoEstimado;

    @Lob
    @Column(
            name = "observaciones",
            length = 500
    )
    private String observaciones;

    @ManyToOne(
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "almazara_id")
    private Almazara almazara;

    @ManyToOne(
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "finca_id")
    private Finca finca;

    @ManyToOne(
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "cuadrilla_id")
    private Cuadrilla cuadrilla;
}
