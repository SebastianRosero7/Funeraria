package com.funeraria.domain.repository;

import com.funeraria.domain.dto.UsuarioDto;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository {

    List<UsuarioDto> getAll();
    Optional<UsuarioDto> getById(Integer id);
    Optional<UsuarioDto> getByIdFuneraria(Integer id);
    UsuarioDto save(UsuarioDto usuarioDto);
    void delete(Integer id);

}
