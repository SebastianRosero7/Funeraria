package com.funeraria.domain.repository;

import com.funeraria.domain.pojo.DepartamentoPojo;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoRepository {

    List<DepartamentoPojo> getAll();
    Optional<DepartamentoPojo> getById(Integer id);
    DepartamentoPojo save(DepartamentoPojo departamentoPojo);
    void delete(Integer id);


}
