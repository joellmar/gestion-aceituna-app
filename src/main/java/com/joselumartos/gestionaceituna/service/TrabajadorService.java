package com.joselumartos.gestionaceituna.service;

import com.joselumartos.gestionaceituna.dto.TrabajadorDto;
import com.joselumartos.gestionaceituna.dto.TrabajadorMapper;
import com.joselumartos.gestionaceituna.model.Trabajador;
import com.joselumartos.gestionaceituna.repository.TrabajadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorService {
    private final TrabajadorRepository repository;
    private final TrabajadorMapper mapper;

    public TrabajadorService(TrabajadorRepository repository, TrabajadorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<TrabajadorDto> listar(Pageable pageable) {
        return this.repository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    public List<TrabajadorDto> listarTodos() {
        return this.repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Trabajador guardar(TrabajadorDto dto) {
        return this.repository.save(mapper.toEntity(dto));
    }

    public void eliminar(Long id) {
        this.repository.deleteById(id);
    }

    public TrabajadorDto buscarPorId(Long id) {
        return this.repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("El trabajador no existe."));
    }

    public List<TrabajadorDto> listarTodosOrdenadosPorCuadrilla() {
        return this.repository
                .findAll(Sort.by("cuadrillas.nombre").ascending())
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
