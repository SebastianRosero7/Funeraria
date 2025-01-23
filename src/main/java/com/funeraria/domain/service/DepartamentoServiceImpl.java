package com.funeraria.domain.service;

import com.funeraria.domain.UseaCase.IDepartamentoUseCase;
import com.funeraria.domain.dto.DepartamentoDto;
import com.funeraria.domain.repository.IDepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DepartamentoServiceImpl implements IDepartamentoUseCase {

    private final IDepartamentoRepository departamentoRepository;


    @Override
    public List<DepartamentoDto> getAll() {
        return departamentoRepository.getAll();
    }

    @Override
    public Optional<DepartamentoDto> getById(Integer id) {
        return departamentoRepository.getById(id);
    }

    @Override
    public DepartamentoDto save(DepartamentoDto departamentoDto) {
        return departamentoRepository.save(departamentoDto);
    }

    @Override
    public Optional<DepartamentoDto> update(DepartamentoDto departamentoDto) {
        if(departamentoRepository.getById(departamentoDto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(departamentoRepository.save(departamentoDto));
    }

    @Override
    public boolean delete(Integer id) {
        if(departamentoRepository.getById(id).isEmpty()){
            return false;
        }

        departamentoRepository.delete(id);
        return true;
    }
}
