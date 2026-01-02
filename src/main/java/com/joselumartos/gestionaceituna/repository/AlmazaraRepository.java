package com.joselumartos.gestionaceituna.repository;

import com.joselumartos.gestionaceituna.model.Almazara;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmazaraRepository extends JpaRepository<Almazara, Long> {
    Page<Almazara> findByCapacidadToneladasDiariasGreaterThanEqual(int capacidad, Pageable pageable);
}
