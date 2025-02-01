package com.funeraria.domain.repository;


import com.funeraria.domain.dto.TitularDto;

import java.util.List;
import java.util.Optional;

public interface ITitularRepository {
    List<TitularDto> getAll();
    Optional<TitularDto> getById(Integer id);
    Optional<TitularDto> getByCedulaCliente(String cedula);
    TitularDto save(TitularDto titularDto);
    void deleteByCedulaCliente(String cedula);
    void delete(Integer id);
}
