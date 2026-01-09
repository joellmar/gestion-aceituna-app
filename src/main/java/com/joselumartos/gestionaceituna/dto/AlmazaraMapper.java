package com.joselumartos.gestionaceituna.dto;

import com.joselumartos.gestionaceituna.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlmazaraMapper {
    AlmazaraMapper INSTANCE = Mappers.getMapper(AlmazaraMapper.class);

    AlmazaraDto toDto(Almazara almazara);

    List<AlmazaraDto> toDtoList(List<Almazara> almazaras);

    Almazara toEntity(AlmazaraDto dto);
}
