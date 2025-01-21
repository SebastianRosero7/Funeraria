package com.funeraria.domain.service;

import com.funeraria.domain.dto.DepartamentoDto;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {

    List<DepartamentoDto> getAll();
    Optional<DepartamentoDto> getById(Integer id);
    DepartamentoDto save(DepartamentoDto departamentoDto);
    Optional<DepartamentoDto> update(DepartamentoDto departamentoDto);
    boolean delete(Integer id);


}
