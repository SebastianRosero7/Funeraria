package com.funeraria.persistance.mapper;

import com.funeraria.domain.dto.DesignadoDto;
import com.funeraria.persistance.entity.DesignadoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDesignadoMapper {

    @Mapping(source = "id",target = "id")
    DesignadoDto toDesignadoDto(DesignadoEntity designadoEntity);

    @InheritInverseConfiguration
    @Mapping(target = "clienteEntity", ignore = true)
    @Mapping(target = "contratoEntity", ignore = true)
    DesignadoEntity toDesignadoEntity(DesignadoDto designadoDto);

    List<DesignadoDto> toDesignadosDto(List<DesignadoEntity> designadoEntities);
}
