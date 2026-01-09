package com.joselumartos.gestionaceituna.dto;

import com.joselumartos.gestionaceituna.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrabajadorMapper {
    TrabajadorMapper INSTANCE = Mappers.getMapper(TrabajadorMapper.class);

    TrabajadorDto toDto(Trabajador trabajador);

    List<TrabajadorDto> toDtoList(List<Trabajador> trabajadores);

    Trabajador toEntity(TrabajadorDto dto);
}
