package com.funeraria.domain.useCase;

import com.funeraria.domain.dto.DesignadoDto;

import java.util.List;
import java.util.Optional;

public interface IDesignadoUseCase {

    List<DesignadoDto> getAll();
    Optional<DesignadoDto> getById(Integer id);
    List<DesignadoDto> getByParentesco(String parentesco);
    Optional<DesignadoDto> getByCedulaCliente(String cedula);
    List<DesignadoDto> getByContrato(String contrato);
    Optional<DesignadoDto> update(DesignadoDto designadoDto);
    DesignadoDto save(DesignadoDto designadoDto);
    boolean delete(Integer id);
    boolean deleteByCedulaCliente(String cedula);
    boolean deleteByContrato(String contrato);
}
