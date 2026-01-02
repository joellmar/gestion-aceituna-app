package com.joselumartos.gestionaceituna.repository;

import com.joselumartos.gestionaceituna.model.Finca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FincaRepository extends JpaRepository<Finca, Long> {
    @Query("SELECT SUM(pr.kilosRecogidos * pr.rendimientoEstimado) FROM ParteRecogida pr JOIN Finca f ON pr.finca = f.nombre WHERE f.nombre = :nombreFinca")
    double getProduccionTotalByFinca(@Param("nombreFinca") String nombreFinca);
}
