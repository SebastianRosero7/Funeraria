package com.funeraria.domain.service;

import com.funeraria.domain.dto.ContratoDto;
import com.funeraria.domain.repository.IContratoRepository;
import com.funeraria.domain.useCase.IContratoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContratoServiceImpl implements IContratoUseCase {

    private final IContratoRepository repository;

    @Override
    public List<ContratoDto> getAll() {
        return repository.getAll();
    }

    @Override
    public Optional<ContratoDto> getById(String id) {
        return repository.getById(id);
    }

    @Override
    public List<ContratoDto> getByTipo(String tipo) {
        return repository.getByTipo(tipo);
    }

    @Override
    public List<ContratoDto> getByAfiliacion(Integer afiliacion) {
        return repository.getByAfiliacion(afiliacion);
    }

    @Override
    public List<ContratoDto> getByFecha(LocalDate fecha) {
        return repository.getByFecha(fecha);
    }

    @Override
    public List<ContratoDto> getByTitular(Integer idTitular) {
        return repository.getByTitular(idTitular);
    }

    @Override
    public List<ContratoDto> getByFuneraria(Integer idFuneraria) {
        return repository.getByFuneraria(idFuneraria);
    }

    @Override
    public Optional<ContratoDto> update(ContratoDto contratoDto) {

        if(repository.getById(contratoDto.getId()).isEmpty()){
            return Optional.empty();
        }

        return Optional.of(repository.save(contratoDto));
    }

    @Override
    public ContratoDto save(ContratoDto contratoDto) {
        return repository.save(contratoDto);
    }

    @Override
    public boolean delete(String codigo) {
        if(repository.getById(codigo).isEmpty()){

            return false;
        }
        repository.delete(codigo);
        return true;
    }
}
