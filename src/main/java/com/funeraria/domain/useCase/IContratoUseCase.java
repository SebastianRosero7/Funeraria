package com.funeraria.domain.useCase;


import com.funeraria.domain.dto.ContratoDto;
import com.funeraria.domain.dto.DepartamentoDto;
import com.funeraria.domain.dto.TitularDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IContratoUseCase {

    List<ContratoDto> getAll();
    Optional<ContratoDto> getById(String id);
    List<ContratoDto> getByTipo(String tipo);
    List<ContratoDto> getByAfiliacion(Integer afiliacion);
    List<ContratoDto> getByFecha(LocalDate fecha);
    List<ContratoDto> getByTitular(Integer idTitular);
    List<ContratoDto> getByFuneraria(Integer idFuneraria);
    Optional<ContratoDto> update(ContratoDto contratoDto);
    ContratoDto save(ContratoDto contratoDto);
    boolean delete(String codigo);

}
