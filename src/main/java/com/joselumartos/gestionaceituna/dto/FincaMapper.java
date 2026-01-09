package com.joselumartos.gestionaceituna.dto;

import com.joselumartos.gestionaceituna.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FincaMapper {
    FincaMapper INSTANCE = Mappers.getMapper(FincaMapper.class);

    FincaDto toDto(Finca finca);

    List<FincaDto> toDtoList(List<Finca> fincas);

    Finca toEntity(FincaDto dto);
}
