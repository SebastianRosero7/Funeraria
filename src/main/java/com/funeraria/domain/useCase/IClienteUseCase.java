package com.funeraria.domain.useCase;

import com.funeraria.domain.dto.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface IClienteUseCase {

    List<ClienteDto> getAll();
    Optional<ClienteDto> getById(Integer cedula);
    List<ClienteDto> getByNombre(String nombre);
    List<ClienteDto> getByApellido(String apellido);
    ClienteDto save(ClienteDto clienteDto);
    Optional<ClienteDto> update(ClienteDto clienteDto);
    boolean delete(Integer cedula);

}
