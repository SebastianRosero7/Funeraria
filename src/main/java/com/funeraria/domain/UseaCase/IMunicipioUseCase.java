package com.funeraria.domain.UseaCase;

import com.funeraria.domain.dto.DepartamentoDto;
import com.funeraria.domain.dto.MunicipioDto;

import java.util.List;
import java.util.Optional;

public interface IMunicipioUseCase {

    List<MunicipioDto> getAll();
    Optional<MunicipioDto> getById(Integer id);
    Optional<MunicipioDto> getByDepartamentoId(Integer id);
    MunicipioDto save(MunicipioDto municipioDto);
    Optional<MunicipioDto> update(MunicipioDto municipioDto);
    boolean delete(Integer id);

}
