package com.funeraria.domain.service;

import com.funeraria.domain.dto.ConvenioDto;
import com.funeraria.domain.repository.IConvenioRepository;
import com.funeraria.domain.useCase.IConvenioUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConvenioServiceImpl implements IConvenioUseCase {

    private final IConvenioRepository repository;

    @Override
    public List<ConvenioDto> getAll() {
        return repository.getAll();
    }

    @Override
    public Optional<ConvenioDto> getById(Integer nit) {
        return repository.getById(nit);
    }

    @Override
    public Optional<ConvenioDto> getByEmpresa(String empresa) {
        return repository.getByEmpresa(empresa);
    }

    @Override
    public Optional<ConvenioDto> getBytitular(String titular) {
        return repository.getBytitular(titular);
    }

    @Override
    public Optional<ConvenioDto> getByCedula(String cedula) {
        return repository.getByCedula(cedula);
    }

    @Override
    public List<ConvenioDto> getByFuneraria(Integer id) {
        return repository.getByFuneraria(id);
    }

    @Override
    public ConvenioDto save(ConvenioDto convenioDto) {

        return repository.save(convenioDto);
    }

    @Override
    public Optional<ConvenioDto> update(ConvenioDto convenioDto) {
        if(repository.getById(convenioDto.getNit()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(repository.save(convenioDto));
    }

    @Override

    public boolean delete(Integer nit) {
        if(repository.getById(nit).isEmpty()) {
            return false;
        }

        repository.delete(nit);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteByCedula(String cedula) {
        if(repository.getByCedula(cedula).isEmpty()) {
            return false;
        }

        repository.deleteByCedula(cedula);
        return true;
    }
}
