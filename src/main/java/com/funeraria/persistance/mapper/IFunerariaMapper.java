package com.funeraria.persistance.mapper;

import com.funeraria.domain.dto.FunerariaDto;
import com.funeraria.persistance.entity.FunerariaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IFunerariaMapper {

    FunerariaDto toFunerariaDto(FunerariaEntity funerariaEntity);
    FunerariaEntity toFunerariaEntity(FunerariaDto funerariaDto);
    List<FunerariaDto> toFunerariasDto(List<FunerariaEntity> funerariasList);
}
