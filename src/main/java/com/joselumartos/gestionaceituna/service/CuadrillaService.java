package com.joselumartos.gestionaceituna.service;

import com.joselumartos.gestionaceituna.dto.CuadrillaDto;
import com.joselumartos.gestionaceituna.dto.CuadrillaMapper;
import com.joselumartos.gestionaceituna.model.Cuadrilla;
import com.joselumartos.gestionaceituna.repository.CuadrillaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CuadrillaService {
    private final CuadrillaRepository repository;
    private final CuadrillaMapper mapper;

    public CuadrillaService(CuadrillaRepository repository, CuadrillaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<CuadrillaDto> listar(Pageable pageable) {
        return this.repository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    public List<CuadrillaDto> listarTodas() {
        return this.repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Cuadrilla guardar(CuadrillaDto dto) {
        return this.repository.save(mapper.toEntity(dto));
    }

    public void eliminar(Long id) {
        this.repository.deleteById(id);
    }

    public CuadrillaDto buscarPorId(Long id) {
        return this.repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Cuadrilla no encontrada"));
    }
}
