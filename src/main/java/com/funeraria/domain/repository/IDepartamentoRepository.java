package com.funeraria.domain.repository;

import com.funeraria.domain.dto.DepartamentoDto;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoRepository {

    List<DepartamentoDto> getAll();
    Optional<DepartamentoDto> getById(Integer id);
    DepartamentoDto save(DepartamentoDto departamentoDto);
    void delete(Integer id);


}
