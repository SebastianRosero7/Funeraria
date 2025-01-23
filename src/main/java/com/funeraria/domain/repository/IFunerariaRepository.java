package com.funeraria.domain.repository;

import com.funeraria.domain.dto.FunerariaDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFunerariaRepository {

    List<FunerariaDto> getAll();
    Optional<FunerariaDto> getById(Integer id);
    Optional<FunerariaDto> findByNombre(String nombre);
    FunerariaDto save(FunerariaDto funerariaDto);
    void delete(Integer id);

}
