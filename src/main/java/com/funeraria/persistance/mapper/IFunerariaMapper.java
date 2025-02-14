package com.funeraria.persistance.mapper;

import com.funeraria.domain.dto.FunerariaDto;
import com.funeraria.persistance.entity.FunerariaEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IFunerariaMapper {
    @Mapping(source = "id",target = "id")
    FunerariaDto toFunerariaDto(FunerariaEntity funerariaEntity);

    @InheritConfiguration
    @Mapping(target = "usuarioEntity", ignore = true)
    @Mapping(target = "clienteEntities", ignore = true)
    @Mapping(target = "contratoEntities", ignore = true)
    @Mapping(target = "convenioEntities", ignore = true)
    FunerariaEntity toFunerariaEntity(FunerariaDto funerariaDto);
    List<FunerariaDto> toFunerariasDto(List<FunerariaEntity> funerariasList);
}
