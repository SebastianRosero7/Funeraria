package com.funeraria.persistance.mapper;

import com.funeraria.domain.dto.UsuarioDto;
import com.funeraria.persistance.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUsuarioMapper {

    @Mapping(target = "id",source = "id")
    UsuarioDto toUsuarioDto(UsuarioEntity usuarioEntity);

    @InheritInverseConfiguration
    @Mapping(target = "funerariaEntity",ignore = true)
    UsuarioEntity toUsuarioEntity(UsuarioDto usuarioDto);

    List<UsuarioDto> toUsuariosDto(List<UsuarioEntity> usuarioEntityList);
}
