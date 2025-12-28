package com.joselumartos.gestionaceituna.model;

import java.time.LocalDate;

public class ParteRecogida {
    private long id;
    private LocalDate fecha;
    private double kilosRecogidos;
    private String observaciones;

    private Almazara almazara;
    private Finca finca;
    private Cuadrilla cuadrilla;
}
