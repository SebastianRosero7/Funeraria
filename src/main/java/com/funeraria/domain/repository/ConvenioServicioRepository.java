package com.funeraria.domain.repository;

import com.funeraria.domain.dto.ClienteDto;
import com.funeraria.domain.dto.ConvenioServicioDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ConvenioServicioRepository {

    List<ConvenioServicioDto> getAll();
    Optional<ConvenioServicioDto> getById(String cedula);
    List<ConvenioServicioDto> getByIdConvenio(Integer idConvenio);
    Optional<ConvenioServicioDto> getByIdServicio(String idServicio);
    List<ConvenioServicioDto> getByFallecido(String nombre);
    Optional<ConvenioServicioDto> getByCedula(String cedula);
    ConvenioServicioDto save(ConvenioServicioDto convenioServicioDto);
    void delete(Integer id);
    void deleteByIdServicio(String idServicio);
    void deleteByCedula(String cedula);

}
