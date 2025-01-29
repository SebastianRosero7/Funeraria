package com.funeraria.domain.service;

import com.funeraria.domain.UseaCase.IMunicipioUseCase;
import com.funeraria.domain.dto.MunicipioDto;
import com.funeraria.domain.repository.IMunicipioReposiroty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MunicipioServiceImpl implements IMunicipioUseCase {

    private final IMunicipioReposiroty municipioReposiroty;

    @Override
    public List<MunicipioDto> getAll() {
        return municipioReposiroty.getAll();
    }

    @Override
    public Optional<MunicipioDto> getById(Integer id) {
        return municipioReposiroty.getById(id);
    }

    @Override
    public Optional<MunicipioDto> getByDepartamentoId(Integer id) {
        return municipioReposiroty.getByDepartamentoId(id);
    }

    @Override
    public MunicipioDto save(MunicipioDto municipioDto) {

        return municipioReposiroty.save(municipioDto);
    }

    @Override
    public Optional<MunicipioDto> update(MunicipioDto municipioDto) {
        if(municipioReposiroty.getById(municipioDto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(municipioReposiroty.save(municipioDto));
    }

    @Override
    public boolean delete(Integer id) {
        if(municipioReposiroty.getById(id).isEmpty()){
            return false;
        }

        municipioReposiroty.delete(id);
        return true;
    }
}
