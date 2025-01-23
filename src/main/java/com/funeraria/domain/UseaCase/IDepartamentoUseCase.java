package com.funeraria.domain.UseaCase;

import com.funeraria.domain.dto.DepartamentoDto;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoUseCase {

    List<DepartamentoDto> getAll();
    Optional<DepartamentoDto> getById(Integer id);
    DepartamentoDto save(DepartamentoDto departamentoDto);
    Optional<DepartamentoDto> update(DepartamentoDto departamentoDto);
    boolean delete(Integer id);


}
