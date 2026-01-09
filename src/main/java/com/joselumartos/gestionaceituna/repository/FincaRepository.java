package com.joselumartos.gestionaceituna.repository;

import com.joselumartos.gestionaceituna.model.Finca;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface FincaRepository extends JpaRepository<Finca, Long> {
}
