package com.funeraria.domain.useCase;

import com.funeraria.domain.dto.FunerariaDto;

import java.util.List;
import java.util.Optional;

public interface IFunerariaUseCase {

    List<FunerariaDto> getAll();
    Optional<FunerariaDto> getById(Integer id);
    Optional<FunerariaDto> findByNombre(String nombre);
    Optional<FunerariaDto> findByEmail(String email);
    Optional<FunerariaDto> update(FunerariaDto funerariaDto);
    FunerariaDto save(FunerariaDto funerariaDto);
    boolean delete(Integer id);

}
