package com.joselumartos.gestionaceituna.dto;

import com.joselumartos.gestionaceituna.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuadrillaMapper {
    CuadrillaMapper INSTANCE = Mappers.getMapper(CuadrillaMapper.class);

    CuadrillaDto toDto(Cuadrilla cuadrilla);

    List<CuadrillaDto> toDtoList(List<Cuadrilla> cuadrillas);

    Cuadrilla toEntity(CuadrillaDto dto);
}
