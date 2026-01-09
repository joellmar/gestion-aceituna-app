package com.joselumartos.gestionaceituna.dto;

import com.joselumartos.gestionaceituna.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParteRecogidaMapper {
    ParteRecogidaMapper INSTANCE = Mappers.getMapper(ParteRecogidaMapper.class);

    @Mapping(source = "almazara.id", target = "almazaraId")
    @Mapping(source = "almazara.nombre", target = "almazaraNombre")
    @Mapping(source = "finca.id", target = "fincaId")
    @Mapping(source = "finca.nombre", target = "fincaNombre")
    @Mapping(source = "cuadrilla.id", target = "cuadrillaId")
    @Mapping(source = "cuadrilla.nombre", target = "cuadrillaNombre")
    ParteRecogidaDto toDto(ParteRecogida parteRecogida);

    List<ParteRecogidaDto> toDtoList(List<ParteRecogida> partesRecogida);

    @Mapping(target = "almazara", ignore = true)
    @Mapping(target = "finca", ignore = true)
    @Mapping(target = "cuadrilla", ignore = true)
    ParteRecogida toEntity(ParteRecogidaDto dto);


}
