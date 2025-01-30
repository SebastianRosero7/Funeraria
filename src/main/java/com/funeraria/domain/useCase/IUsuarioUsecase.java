package com.funeraria.domain.useCase;

import com.funeraria.domain.dto.UsuarioDto;

import java.util.List;
import java.util.Optional;

public interface IUsuarioUsecase {

    List<UsuarioDto> getAll();
    Optional<UsuarioDto> getById(Integer id);
    Optional<UsuarioDto> getByIdFuneraria(Integer id);
    Optional<UsuarioDto> update(UsuarioDto usuarioDto);
    UsuarioDto save(UsuarioDto usuarioDto);
    boolean delete(Integer id);
}
