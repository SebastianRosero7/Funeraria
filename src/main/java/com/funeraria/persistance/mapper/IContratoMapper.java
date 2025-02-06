package com.funeraria.persistance.mapper;

import com.funeraria.domain.dto.ContratoDto;
import com.funeraria.persistance.entity.ContratoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IContratoMapper {

    @Mapping(source = "id",target = "id")
    ContratoDto toContratoDto(ContratoEntity contrato);

    @InheritInverseConfiguration
    @Mapping(target = "funerariaEntity", ignore = true)
    @Mapping(target = "titularEntity", ignore = true)
    @Mapping(target = "designadoEntities", ignore = true)
    ContratoEntity toContratoEntity(ContratoDto dto);
    List<ContratoDto> toContratosDto(List<ContratoEntity> contratos);
}
