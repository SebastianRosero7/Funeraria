package com.funeraria.domain.repository;

import com.funeraria.domain.dto.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository {

    List<ClienteDto> getAll();
    Optional<ClienteDto> getById(String cedula);
    List<ClienteDto> getByNombre(String nombre);
    List<ClienteDto> getByApellido(String apellido);
    ClienteDto save(ClienteDto clienteDto);
    void delete(String cedula);


}
