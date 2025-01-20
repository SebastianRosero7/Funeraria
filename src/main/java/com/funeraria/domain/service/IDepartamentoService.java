package com.funeraria.domain.service;

import com.funeraria.domain.pojo.DepartamentoPojo;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {

    List<DepartamentoPojo> getAll();
    Optional<DepartamentoPojo> getById(Integer id);
    DepartamentoPojo save(DepartamentoPojo departamentoPojo);
    Optional<DepartamentoPojo> update(DepartamentoPojo departamentoPojo);
    boolean delete(Integer id);


}
