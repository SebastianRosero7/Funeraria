package com.funeraria.domain.repository;

import com.funeraria.domain.dto.ClienteDto;
import com.funeraria.domain.dto.ConvenioDto;

import java.util.List;
import java.util.Optional;

public interface IConvenioRepository {

    List<ConvenioDto> getAll();
    Optional<ConvenioDto> getById(Integer nit);
    Optional<ConvenioDto> getByEmpresa(String empresa);
    Optional<ConvenioDto> getBytitular(String titular);
    Optional<ConvenioDto> getByCedula(String cedula);
    List<ConvenioDto> getByFuneraria(Integer id);
    ConvenioDto save(ConvenioDto convenioDto);
    void delete(Integer nit);
    void deleteByCedula(String cedula);

}
