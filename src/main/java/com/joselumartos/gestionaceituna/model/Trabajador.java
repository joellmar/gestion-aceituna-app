package com.joselumartos.gestionaceituna.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "trabajadores"
)
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String dni;
    private String telefono;
    private String categoriaProfesional;
    private boolean activo;

    private List<Cuadrilla> cuadrillas;
}
