package com.funeraria.persistance.repository;

import com.funeraria.domain.dto.TitularDto;
import com.funeraria.domain.repository.ITitularRepository;
import com.funeraria.persistance.entity.TitularEntity;
import com.funeraria.persistance.jpa.ITitularRepositoryCRUD;
import com.funeraria.persistance.mapper.ITitularMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TitularRepositoryImpl implements ITitularRepository {

    private final ITitularRepositoryCRUD titularRepositoryCRUD;
    private final ITitularMapper titularMapper;

    @Override
    public List<TitularDto> getAll() {
        return titularMapper.toTitularesDto(titularRepositoryCRUD.findAll());
    }

    @Override
    public Optional<TitularDto> getById(Integer id) {
        return titularRepositoryCRUD.findById(id).map(titularMapper::toTitularDto);
    }

    @Override
    public Optional<TitularDto> getByCedulaCliente(String cedula) {
        return titularRepositoryCRUD.findByCedulaCliente(cedula).map(titularMapper::toTitularDto);
    }

    @Override
    public TitularDto save(TitularDto titularDto) {
        TitularEntity titularEntity = titularMapper.toTitularEntity(titularDto);
        return titularMapper.toTitularDto(titularRepositoryCRUD.save(titularEntity));
    }

    @Override
    public void deleteByCedulaCliente(String cedula) {
        titularRepositoryCRUD.deleteByCedulaCliente(cedula);
    }

    @Override
    public void delete(Integer id) {
        titularRepositoryCRUD.deleteById(id);
    }
}
