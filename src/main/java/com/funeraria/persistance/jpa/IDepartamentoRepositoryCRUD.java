package com.funeraria.persistance.jpa;

import com.funeraria.persistance.entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartamentoRepositoryCRUD extends JpaRepository<DepartamentoEntity,Integer> {

}
