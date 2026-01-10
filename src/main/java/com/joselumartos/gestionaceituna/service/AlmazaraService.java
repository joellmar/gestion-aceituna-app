package com.joselumartos.gestionaceituna.service;

import com.joselumartos.gestionaceituna.dto.AlmazaraDto;
import com.joselumartos.gestionaceituna.dto.AlmazaraMapper;
import com.joselumartos.gestionaceituna.model.Almazara;
import com.joselumartos.gestionaceituna.repository.AlmazaraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmazaraService {
    private final AlmazaraRepository repository;
    private final AlmazaraMapper mapper;

    public AlmazaraService(AlmazaraRepository repository, AlmazaraMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<AlmazaraDto> listar(Pageable pageable) {
        return this.repository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    public List<AlmazaraDto> listarTodas() {
        return this.repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Almazara guardar(AlmazaraDto dto) {
        return this.repository.save(mapper.toEntity(dto));
    }

    public AlmazaraDto buscarPorId(Long id) {
        return this.repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Almazara no encontrada"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Page<AlmazaraDto> listarAlmazarasPorVolumenDesc() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("capacidadToneladasDiarias"));
        return this.repository
                .findByCapacidadToneladasDiariasGreaterThanEqual(0, pageable)
                .map(mapper::toDto);
    }
}
