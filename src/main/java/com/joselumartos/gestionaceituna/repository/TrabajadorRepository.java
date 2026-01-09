package com.joselumartos.gestionaceituna.repository;

import com.joselumartos.gestionaceituna.model.Trabajador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    int countByCuadrillasNombre(String nombreCuadrilla);

    List<Trabajador> findByCuadrillasNombre(String nombreCuadrilla);

    Page<Trabajador> findByCuadrillasId(Long id, Pageable pageable);
}
