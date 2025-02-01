package com.funeraria.persistance.repository;

import com.funeraria.domain.dto.ClienteDto;
import com.funeraria.domain.repository.IClienteRepository;
import com.funeraria.persistance.entity.ClienteEntity;
import com.funeraria.persistance.jpa.IClienteRepositoryCRUD;
import com.funeraria.persistance.mapper.IClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements IClienteRepository {

    private final IClienteRepositoryCRUD clienteRepositoryCRUD;
    @Qualifier("IClienteMapper")
    private final IClienteMapper clienteMapper;

    @Override
    public List<ClienteDto> getAll() {
        return clienteMapper.toClientesDto(clienteRepositoryCRUD.findAll());
    }

    @Override
    public Optional<ClienteDto> getById(String cedula) {
        return clienteRepositoryCRUD.findById(cedula).map(clienteMapper::toClientesDto);
    }

    @Override
    public List<ClienteDto> getByNombre(String nombre) {
        return clienteMapper.toClientesDto(clienteRepositoryCRUD.findByNombre(nombre));
    }

    @Override
    public List<ClienteDto> getByApellido(String apellido) {
        return clienteMapper.toClientesDto(clienteRepositoryCRUD.findByApellido(apellido));
    }

    @Override
    public ClienteDto save(ClienteDto clienteDto) {
        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(clienteDto);
        return clienteMapper.toClientesDto(clienteRepositoryCRUD.save(clienteEntity));
    }

    @Override
    public void delete(String cedula) {
        clienteRepositoryCRUD.deleteById(cedula);
    }
}
