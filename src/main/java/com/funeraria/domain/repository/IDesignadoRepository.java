package com.funeraria.domain.repository;

import com.funeraria.domain.dto.DesignadoDto;

import java.util.List;
import java.util.Optional;

public interface IDesignadoRepository {
    List<DesignadoDto> getAll();
    Optional<DesignadoDto> getById(Integer id);
    List<DesignadoDto> getByParentesco(String parentesco);
    Optional<DesignadoDto> getByCedulaCliente(String cedula);
    List<DesignadoDto> getByContrato(String contrato);
    DesignadoDto save(DesignadoDto designadoDto);
    void delete(Integer id);
    void deleteByCedulaCliente(String cedula);
    void deleteByContrato(String contrato);

}
