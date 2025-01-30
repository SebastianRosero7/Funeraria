package com.funeraria.persistance.mapper;

import com.funeraria.domain.dto.MunicipioDto;
import com.funeraria.persistance.entity.MunicipioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMunicipioMapper {
    @Mapping(source = "id",target = "id")
    MunicipioDto toMunicipioDto(MunicipioEntity municipioEntity);

    @InheritInverseConfiguration
    @Mapping(target = "departamentoEntity", ignore = true)
    @Mapping(target = "clienteEntities",ignore = true)
    MunicipioEntity toMunicipioEntity(MunicipioDto municipioDto);

    List<MunicipioDto> toMunicipiosDto(List<MunicipioEntity> municipioEntities);
}
