package com.joselumartos.gestionaceituna.repository;

import com.joselumartos.gestionaceituna.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    List<Trabajador> countByCuadrillas_Nombre(String nombreCuadrilla);
}
