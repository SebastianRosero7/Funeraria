package com.funeraria.domain.repository;

import com.funeraria.domain.dto.MunicipioDto;

import java.util.List;
import java.util.Optional;

public interface IMunicipioReposiroty {

    List<MunicipioDto> getAll();
    Optional<MunicipioDto> getById(Integer id);
    List<MunicipioDto> getByDepartamentoId(Integer id);
    MunicipioDto save(MunicipioDto municipioDto);
    void delete(Integer id);



}
