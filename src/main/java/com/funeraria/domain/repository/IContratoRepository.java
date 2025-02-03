package com.funeraria.domain.repository;


import com.funeraria.domain.dto.ContratoDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IContratoRepository {
    List<ContratoDto> getAll();
    Optional<ContratoDto> getById(String id);
    List<ContratoDto> getByTipo(String tipo);
    List<ContratoDto> getByAfiliacion(Integer afiliacion);
    List<ContratoDto> getByFecha(LocalDate fecha);
    List<ContratoDto> getByTitular(Integer idTitular);
    List<ContratoDto> getByFuneraria(Integer idFuneraria);
    ContratoDto save(ContratoDto contratoDto);
    void delete(String codigo);

}
