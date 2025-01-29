package com.funeraria.persistance.mapper;

import com.funeraria.domain.dto.ClienteDto;
import com.funeraria.persistance.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    ClienteDto toClientesDto(ClienteEntity clienteEntity);
    //@Mapping(target = "")
    ClienteEntity toClienteEntity(ClienteDto clienteDto);
    List<ClienteDto> toClientesDto(List<ClienteEntity> clienteEntities);

}
