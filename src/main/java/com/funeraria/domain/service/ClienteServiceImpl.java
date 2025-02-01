package com.funeraria.domain.service;

import com.funeraria.domain.dto.ClienteDto;
import com.funeraria.domain.repository.IClienteRepository;
import com.funeraria.domain.useCase.IClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteUseCase {

    private final IClienteRepository clienteRepository;

    @Override
    public List<ClienteDto> getAll() {
        return clienteRepository.getAll();
    }

    @Override
    public Optional<ClienteDto> getById(String cedula) {
        return clienteRepository.getById(cedula);
    }

    @Override
    public List<ClienteDto> getByNombre(String nombre) {
        return clienteRepository.getByNombre(nombre);
    }

    @Override
    public List<ClienteDto> getByApellido(String apellido) {
        return clienteRepository.getByApellido(apellido);
    }

    @Override
    public ClienteDto save(ClienteDto clienteDto) {
        return clienteRepository.save(clienteDto);
    }

    @Override
    public Optional<ClienteDto> update(ClienteDto clienteDto) {
        if(clienteRepository.getById(clienteDto.getCedula()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(clienteRepository.save(clienteDto));

    }

    @Override
    public boolean delete(String cedula) {
        if(clienteRepository.getById(cedula).isEmpty()){
            return false;
        }

        clienteRepository.delete(cedula);
        return true;
    }
}
