package com.funeraria.domain.useCase;

import com.funeraria.domain.dto.TitularDto;

import java.util.List;
import java.util.Optional;

public interface ITitularUseCase {
    List<TitularDto> getAll();
    Optional<TitularDto> getById(Integer id);
    Optional<TitularDto> getByCedulaCliente(String cedula);
    TitularDto save(TitularDto titularDto);
    Optional<TitularDto> update(TitularDto titularDto);
    boolean deleteByCedulaCliente(String cedula);
    boolean delete(Integer id);
}
