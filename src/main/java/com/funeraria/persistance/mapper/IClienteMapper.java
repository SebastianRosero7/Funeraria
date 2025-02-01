package com.funeraria.persistance.mapper;

import com.funeraria.domain.dto.ClienteDto;
import com.funeraria.persistance.entity.ClienteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    @Mapping(source = "cedula",target = "cedula")
    ClienteDto toClientesDto(ClienteEntity clienteEntity);

    @InheritInverseConfiguration
    @Mapping(target = "municipioEntity", ignore = true)
    @Mapping(target = "funerariaEntity", ignore = true)
    @Mapping(target = "titularEntity", ignore = true)
    ClienteEntity toClienteEntity(ClienteDto clienteDto);

    List<ClienteDto> toClientesDto(List<ClienteEntity> clienteEntities);

}
