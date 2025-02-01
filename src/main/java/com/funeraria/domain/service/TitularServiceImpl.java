package com.funeraria.domain.service;

import com.funeraria.domain.dto.TitularDto;
import com.funeraria.domain.repository.ITitularRepository;
import com.funeraria.domain.useCase.ITitularUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TitularServiceImpl implements ITitularUseCase {
    private final ITitularRepository titularRepository;
    @Override
    public List<TitularDto> getAll() {
        return titularRepository.getAll();
    }

    @Override
    public Optional<TitularDto> getById(Integer id) {
        return titularRepository.getById(id);
    }

    @Override
    public Optional<TitularDto> getByCedulaCliente(String cedula) {
        return titularRepository.getByCedulaCliente(cedula);
    }

    @Override
    public TitularDto save(TitularDto titularDto) {

        return titularRepository.save(titularDto);
    }

    @Override
    public Optional<TitularDto> update(TitularDto titularDto) {
        if(titularRepository.getById(titularDto.getId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(titularRepository.save(titularDto)) ;
    }

    @Override
    public boolean deleteByCedulaCliente(String cedula) {
        if(titularRepository.getByCedulaCliente(cedula).isEmpty()) {
            return false;
        }

        titularRepository.deleteByCedulaCliente(cedula);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        if(titularRepository.getById(id).isEmpty()) {
            return false;
        }

        titularRepository.delete(id);
        return true;
    }
}
