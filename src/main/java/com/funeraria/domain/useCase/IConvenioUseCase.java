package com.funeraria.domain.useCase;

import com.funeraria.domain.dto.ConvenioDto;

import java.util.List;
import java.util.Optional;

public interface IConvenioUseCase {

    List<ConvenioDto> getAll();
    Optional<ConvenioDto> getById(Integer nit);
    Optional<ConvenioDto> getByEmpresa(String empresa);
    Optional<ConvenioDto> getBytitular(String titular);
    Optional<ConvenioDto> getByCedula(String cedula);
    List<ConvenioDto> getByFuneraria(Integer id);
    ConvenioDto save(ConvenioDto convenioDto);
    Optional<ConvenioDto> update(ConvenioDto convenioDto);
    boolean delete(Integer nit);
    boolean deleteByCedula(String cedula);

}
