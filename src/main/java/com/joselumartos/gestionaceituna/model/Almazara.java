package com.joselumartos.gestionaceituna.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "almazaras")
public class Almazara {

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
            name = "direccion",
            length = 100
    )
    private String direccion;

    @Column(
            name = "telefono",
            length = 9
    )
    private String telefono;

    @Column(
            name = "capacidad_toneladas_diarias"
    )
    private int capacidadToneladasDiarias;

    @Transient
    private List<ParteRecogida> partesRecogida;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCapacidadToneladasDiarias() {
        return capacidadToneladasDiarias;
    }

    public void setCapacidadToneladasDiarias(int capacidadToneladasDiarias) {
        this.capacidadToneladasDiarias = capacidadToneladasDiarias;
    }

    public List<ParteRecogida> getPartesRecogida() {
        return partesRecogida;
    }

    public void setPartesRecogida(List<ParteRecogida> partesRecogida) {
        this.partesRecogida = partesRecogida;
    }
}
