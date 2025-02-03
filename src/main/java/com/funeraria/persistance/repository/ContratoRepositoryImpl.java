package com.funeraria.persistance.repository;

import com.funeraria.domain.dto.ContratoDto;
import com.funeraria.domain.repository.IContratoRepository;
import com.funeraria.persistance.entity.ContratoEntity;
import com.funeraria.persistance.jpa.IContratoRepositoryCRUD;
import com.funeraria.persistance.mapper.IContratoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ContratoRepositoryImpl implements IContratoRepository {

    private final IContratoRepositoryCRUD repositoryCRUD;
    private final IContratoMapper mapper;

    @Override
    public List<ContratoDto> getAll() {
        return mapper.toContratosDto(repositoryCRUD.findAll());
    }

    @Override
    public Optional<ContratoDto> getById(String id) {
        return repositoryCRUD.findById(id).map(mapper::toContratoDto);
    }

    @Override
    public List<ContratoDto> getByTipo(String tipo) {
        return mapper.toContratosDto(repositoryCRUD.findByTipoContrato(tipo));
    }

    @Override
    public List<ContratoDto> getByAfiliacion(Integer afiliacion) {
        return mapper.toContratosDto(repositoryCRUD.findByAfiliacion(afiliacion));
    }

    @Override
    public List<ContratoDto> getByFecha(LocalDate fecha) {
        return mapper.toContratosDto(repositoryCRUD.findByFechaContrato(fecha));
    }

    @Override
    public List<ContratoDto> getByTitular(Integer idTitular) {
        return mapper.toContratosDto(repositoryCRUD.findByTitularId(idTitular));
    }

    @Override
    public List<ContratoDto> getByFuneraria(Integer idFuneraria) {
        return mapper.toContratosDto(repositoryCRUD.findByFunerariaId(idFuneraria));
    }

    @Override
    public ContratoDto save(ContratoDto contratoDto) {
        ContratoEntity contratoEntity = mapper.toContratoEntity(contratoDto);

        return mapper.toContratoDto(repositoryCRUD.save(contratoEntity));
    }

    @Override
    public void delete(String codigo) {
        repositoryCRUD.deleteById(codigo);
    }
}
