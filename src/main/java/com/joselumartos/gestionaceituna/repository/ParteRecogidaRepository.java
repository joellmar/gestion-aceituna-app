package com.joselumartos.gestionaceituna.repository;

import com.joselumartos.gestionaceituna.model.ParteRecogida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ParteRecogidaRepository extends JpaRepository<ParteRecogida, Long> {
    List<ParteRecogida> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
}
