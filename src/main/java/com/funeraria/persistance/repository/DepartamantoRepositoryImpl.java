package com.funeraria.persistance.repository;

import com.funeraria.domain.dto.DepartamentoDto;
import com.funeraria.domain.repository.IDepartamentoRepository;
import com.funeraria.persistance.entity.DepartamentoEntity;
import com.funeraria.persistance.jpa.IDepartamentoRepositoryCRUD;
import com.funeraria.persistance.mapper.IDepartamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class DepartamantoRepositoryImpl implements IDepartamentoRepository {

    private final IDepartamentoRepositoryCRUD departamentoRepositoryCRUD;
    @Qualifier("IDepartamentoMapper")
    private final IDepartamentoMapper departamentoMapper;



    @Override
    public List<DepartamentoDto> getAll() {
        return departamentoMapper.toDepartamentosPojo( departamentoRepositoryCRUD.findAll());
    }

    @Override
    public Optional<DepartamentoDto> getById(Integer id) {
        return departamentoRepositoryCRUD.findById(id).map(departamentoMapper::toDepartamentoPojo);
    }

    @Override
    public DepartamentoDto save(DepartamentoDto departamentoDto) {
        DepartamentoEntity departamentoEntity = departamentoMapper.toDepartamentoEntity(departamentoDto);
        return departamentoMapper.toDepartamentoPojo(departamentoRepositoryCRUD.save(departamentoEntity));
    }

    @Override
    public void delete(Integer id) {
        departamentoRepositoryCRUD.deleteById(id);

    }
}
