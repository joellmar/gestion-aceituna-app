package com.joselumartos.gestionaceituna.service;

import com.joselumartos.gestionaceituna.dto.ParteRecogidaDto;
import com.joselumartos.gestionaceituna.dto.ParteRecogidaMapper;
import com.joselumartos.gestionaceituna.model.ParteRecogida;
import com.joselumartos.gestionaceituna.repository.AlmazaraRepository;
import com.joselumartos.gestionaceituna.repository.CuadrillaRepository;
import com.joselumartos.gestionaceituna.repository.FincaRepository;
import com.joselumartos.gestionaceituna.repository.ParteRecogidaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ParteRecogidaService {
    private final ParteRecogidaRepository repository;
    private final ParteRecogidaMapper mapper;
    private final FincaRepository fincaRepo;
    private final CuadrillaRepository cuadrillaRepo;
    private final AlmazaraRepository almazaraRepo;

    public ParteRecogidaService(ParteRecogidaRepository repository, ParteRecogidaMapper mapper,
                                FincaRepository fincaRepo, CuadrillaRepository cuadrillaRepo,
                                AlmazaraRepository almazaraRepo) {
        this.repository = repository;
        this.mapper = mapper;
        this.fincaRepo = fincaRepo;
        this.cuadrillaRepo = cuadrillaRepo;
        this.almazaraRepo = almazaraRepo;
    }

    public Page<ParteRecogidaDto> listar(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    public List<ParteRecogidaDto> listarTodos() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ParteRecogida guardar(ParteRecogidaDto dto) {
        ParteRecogida parte = mapper.toEntity(dto);

        // Asignación manual de relaciones debido al "ignore" del mapper
        parte.setFinca(
                fincaRepo
                        .findById(dto.fincaId())
                        .orElseThrow(() -> new EntityNotFoundException("La finca no existe."))
        );
        parte.setCuadrilla(
                cuadrillaRepo
                        .findById(dto.cuadrillaId())
                        .orElseThrow(() -> new EntityNotFoundException("La cuadrilla no existe."))
        );
        parte.setAlmazara(
                almazaraRepo
                        .findById(dto.almazaraId())
                        .orElseThrow(() -> new EntityNotFoundException("La almazara no existe."))
        );

        return this.repository.save(parte);
    }

    public void eliminar(Long id) {
        this.repository.deleteById(id);
    }

    public List<ParteRecogidaDto> buscarEntreFechas(LocalDate inicio, LocalDate fin) {
        return this.repository
                .findByFechaBetween(inicio, fin)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public double obtenerProduccionTotalPorFinca(String nombreFinca) {
        return this.repository.getProduccionTotalByFinca(nombreFinca);
    }

    public double obtenerKilosRecogidosPorAlmazaraEntreFechas(Long almazaraId, LocalDate inicio, LocalDate fin) {
        return this.repository.sumKilosRecogidosByAlmazaraIdAndFechaBetween(almazaraId, inicio, fin);
    }
}
