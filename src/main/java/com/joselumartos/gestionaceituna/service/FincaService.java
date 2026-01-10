package com.joselumartos.gestionaceituna.service;

import com.joselumartos.gestionaceituna.dto.FincaDto;
import com.joselumartos.gestionaceituna.dto.FincaMapper;
import com.joselumartos.gestionaceituna.model.Finca;
import com.joselumartos.gestionaceituna.repository.FincaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FincaService {
    private final FincaRepository repository;
    private final FincaMapper mapper;

    public FincaService(FincaRepository repository, FincaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<FincaDto> listar(Pageable pageable) {
        return this.repository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    public List<FincaDto> listarTodas() {
        return this.repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Finca guardar(FincaDto dto) {
        return this.repository.save(mapper.toEntity(dto));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public FincaDto buscarPorId(Long id) {
        return this.repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada"));
    }
}