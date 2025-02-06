package com.funeraria.persistance.repository;

import com.funeraria.domain.dto.DesignadoDto;
import com.funeraria.domain.repository.IDesignadoRepository;
import com.funeraria.persistance.entity.DesignadoEntity;
import com.funeraria.persistance.jpa.IDesignadoRepositoryCRUD;
import com.funeraria.persistance.mapper.IDesignadoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DesignadoRepositoryImpl implements IDesignadoRepository {

    private final IDesignadoRepositoryCRUD designadoRepository;

    @Qualifier("IDesignadoMapper")
    private final IDesignadoMapper designadoMapper;

    @Override
    public List<DesignadoDto> getAll() {
        return designadoMapper.toDesignadosDto(designadoRepository.findAll());
    }

    @Override
    public Optional<DesignadoDto> getById(Integer id) {
        return designadoRepository.findById(id).map(designadoMapper::toDesignadoDto);
    }

    @Override
    public List<DesignadoDto> getByParentesco(String parentesco) {
        return designadoMapper.toDesignadosDto(designadoRepository.findByParentesco(parentesco));
    }

    @Override
    public Optional<DesignadoDto> getByCedulaCliente(String cedula) {
        return designadoRepository.findByCedulaCliente(cedula).map(designadoMapper::toDesignadoDto);
    }

    @Override
    public List<DesignadoDto> getByContrato(String contrato) {
        return designadoMapper.toDesignadosDto(designadoRepository.findByNumeroContrato(contrato));
    }

    @Override
    public DesignadoDto save(DesignadoDto designadoDto) {
        DesignadoEntity designadoEntity = designadoMapper.toDesignadoEntity(designadoDto);
        return designadoMapper.toDesignadoDto(designadoRepository.save(designadoEntity));
    }

    @Override
    public void delete(Integer id) {
        designadoRepository.deleteById(id);
    }

    @Override
    public void deleteByCedulaCliente(String cedula) {
        designadoRepository.deleteByCedulaCliente(cedula);
    }

    @Override
    public void deleteByContrato(String contrato) {
        designadoRepository.deleteByNumeroContrato(contrato);
    }
}
