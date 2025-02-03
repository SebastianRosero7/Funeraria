package com.funeraria.persistance.mapper;

import com.funeraria.domain.dto.TitularDto;
import com.funeraria.persistance.entity.TitularEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITitularMapper {

    @Mapping(source = "id",target = "id")
    TitularDto toTitularDto(TitularEntity titularEntity);

    @Mapping(target = "clienteEntity", ignore = true)
    @Mapping(target = "contratoEntity", ignore = true)
    @InheritInverseConfiguration
    TitularEntity toTitularEntity(TitularDto titularDto);
    List<TitularDto> toTitularesDto(List<TitularEntity> titularEntities);
}
