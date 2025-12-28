package com.joselumartos.gestionaceituna.model;

import java.util.List;

public class Finca {
    private long id;
    private String nombre;
    private String propietario;
    private double extensionHectareas;
    private String variedadAceituna;
    private boolean activaCampaña;

    private List<ParteRecogida> partesRecogida;
    private List<Cuadrilla> cuadrillas;
}
