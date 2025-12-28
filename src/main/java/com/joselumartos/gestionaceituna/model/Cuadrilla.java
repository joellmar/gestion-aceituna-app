package com.joselumartos.gestionaceituna.model;

import java.util.List;

public class Cuadrilla {
    private long id;
    private String nombre;
    private String responsable;
    private int numeroMaximoTrabajadores;
    private boolean activa;

    private List<ParteRecogida> partesRecogida;
    private List<Finca> fincas;
    private List<Trabajador> trabajadores;
}
