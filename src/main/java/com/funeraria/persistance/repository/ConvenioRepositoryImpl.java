package com.funeraria.persistance.repository;

import com.funeraria.domain.dto.ConvenioDto;
import com.funeraria.domain.repository.IConvenioRepository;
import com.funeraria.persistance.entity.ConvenioEntity;
import com.funeraria.persistance.jpa.IConvenioRepositoryCRUD;
import com.funeraria.persistance.mapper.IConvenioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ConvenioRepositoryImpl implements IConvenioRepository {

    private final IConvenioRepositoryCRUD convenioRepositoryCRUD;

    @Qualifier("IConvenioMapper")
    private final IConvenioMapper convenioMapper;

    @Override
    public List<ConvenioDto> getAll() {
        return convenioMapper.toConveniosDto(convenioRepositoryCRUD.findAll());
    }

    @Override
    public Optional<ConvenioDto> getById(Integer nit) {
        return convenioRepositoryCRUD.findById(nit).map(convenioMapper::toConvenioDto);
    }

    @Override
    public Optional<ConvenioDto> getByEmpresa(String empresa) {
        return convenioRepositoryCRUD.findByEmpresa(empresa).map(convenioMapper::toConvenioDto);
    }

    @Override
    public Optional<ConvenioDto> getBytitular(String titular) {
        return convenioRepositoryCRUD.findByTitular(titular).map(convenioMapper::toConvenioDto);
    }

    @Override
    public Optional<ConvenioDto> getByCedula(String cedula) {
        return convenioRepositoryCRUD.findByCedula(cedula).map(convenioMapper::toConvenioDto);
    }

    @Override
    public List<ConvenioDto> getByFuneraria(Integer id) {
        return convenioMapper.toConveniosDto(convenioRepositoryCRUD.findByFunerariaId(id));
    }

    @Override
    public ConvenioDto save(ConvenioDto convenioDto) {
        ConvenioEntity convenioEntity = convenioMapper.toConvenioEntity(convenioDto);
        return convenioMapper.toConvenioDto(convenioRepositoryCRUD.save(convenioEntity));
    }

    @Override
    public void delete(Integer nit) {
        convenioRepositoryCRUD.deleteById(nit);
    }

    @Override
    public void deleteByCedula(String cedula) {
        convenioRepositoryCRUD.deleteByCedula(cedula);
    }
}
