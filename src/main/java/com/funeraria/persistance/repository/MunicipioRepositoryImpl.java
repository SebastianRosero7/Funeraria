package com.funeraria.persistance.repository;

import com.funeraria.domain.dto.MunicipioDto;
import com.funeraria.domain.repository.IMunicipioReposiroty;
import com.funeraria.persistance.entity.MunicipioEntity;
import com.funeraria.persistance.jpa.IMunicipioRepositoryCRUD;
import com.funeraria.persistance.mapper.IMunicipioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class MunicipioRepositoryImpl implements IMunicipioReposiroty {

    private final IMunicipioMapper municipioMapper;
    private final IMunicipioRepositoryCRUD municipioRepositoryCRUD;

    @Override
    public List<MunicipioDto> getAll() {
        return municipioMapper.toMunicipiosDto(municipioRepositoryCRUD.findAll());
    }

    @Override
    public Optional<MunicipioDto> getById(Integer id) {
        return municipioRepositoryCRUD.findById(id).map(municipioMapper::toMunicipioDto);
    }

    @Override
    public Optional<MunicipioDto> getByDepartamentoId(Integer id) {
        return municipioRepositoryCRUD.findByDepartamentoId(id).map(municipioMapper::toMunicipioDto);
    }

    @Override
    public MunicipioDto save(MunicipioDto municipioDto) {
        MunicipioEntity municipioEntity= municipioMapper.toMunicipioEntity(municipioDto);
        return municipioMapper.toMunicipioDto(municipioRepositoryCRUD.save(municipioEntity));
    }

    @Override
    public void delete(Integer id) {
        municipioRepositoryCRUD.deleteById(id);
    }
}
