package com.joselumartos.gestionaceituna.repository;

import com.joselumartos.gestionaceituna.model.ParteRecogida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ParteRecogidaRepository extends JpaRepository<ParteRecogida, Long> {
    List<ParteRecogida> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);

    Page<ParteRecogida> findByAlmazaraId(Long id, Pageable pageable);

    Page<ParteRecogida> findByFincaId(Long id, Pageable pageable);

    Page<ParteRecogida> findByCuadrillaId(Long id, Pageable pageable);

    @Query("SELECT SUM(pr.kilosRecogidos * pr.rendimientoEstimado) FROM ParteRecogida pr WHERE pr.finca.nombre = :nombreFinca")
    double getProduccionTotalByFinca(@Param("nombreFinca") String nombreFinca);

    double sumKilosRecogidosByAlmazaraIdAndFechaBetween(Long almazaraId, LocalDate inicio, LocalDate fin);

}
