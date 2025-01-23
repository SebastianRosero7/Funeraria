package com.funeraria.persistance.repository;

import com.funeraria.domain.dto.FunerariaDto;
import com.funeraria.domain.repository.IFunerariaRepository;
import com.funeraria.persistance.entity.FunerariaEntity;
import com.funeraria.persistance.jpa.IFunerariaRepositoryCRUD;
import com.funeraria.persistance.mapper.IFunerariaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class FunerariaRepositoryImpl implements IFunerariaRepository {

    private final IFunerariaRepositoryCRUD funerariaRepositoryCRUD;
    @Qualifier("IFunerariaMapper")
    private final IFunerariaMapper funerariaMapper;

    @Override
    public List<FunerariaDto> getAll() {
        return funerariaMapper.toFunerariasDto(funerariaRepositoryCRUD.findAll());
    }

    @Override
    public Optional<FunerariaDto> getById(Integer id) {
        return funerariaRepositoryCRUD.findById(id)
                .map(funerariaMapper::toFunerariaDto);
    }

    @Override
    public Optional<FunerariaDto> findByNombre(String nombre) {
        return funerariaRepositoryCRUD.findByNombre(nombre)
                .map(funerariaMapper::toFunerariaDto);
    }

    @Override
    public Optional<FunerariaDto> findByEmail(String email) {
        return funerariaRepositoryCRUD.findByEmail(email)
                .map(funerariaMapper::toFunerariaDto);
    }

    @Override
    public FunerariaDto save(FunerariaDto funerariaDto) {
        FunerariaEntity funerariaEntity= funerariaMapper.toFunerariaEntity(funerariaDto);
        return funerariaMapper.toFunerariaDto(funerariaRepositoryCRUD.save(funerariaEntity));
    }

    @Override
    public void delete(Integer id) {
        funerariaRepositoryCRUD.deleteById(id);
    }
}
