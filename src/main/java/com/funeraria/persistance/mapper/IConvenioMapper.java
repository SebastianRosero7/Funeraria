package com.funeraria.persistance.mapper;

import com.funeraria.domain.dto.ConvenioDto;
import com.funeraria.persistance.entity.ConvenioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IConvenioMapper {

    @Mapping(source = "nit",target = "nit")
    ConvenioDto toConvenioDto(ConvenioEntity convenioEntity);

    @Mapping(target = "funerariaEntity", ignore = true)
    @InheritInverseConfiguration
    ConvenioEntity toConvenioEntity(ConvenioDto convenioDto);
    List<ConvenioDto> toConveniosDto(List<ConvenioEntity> convenioEntities);
}
