package com.funeraria.persistance.jpa;

import com.funeraria.persistance.entity.MunicipioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMunicipioRepositoryCRUD extends JpaRepository<MunicipioEntity,Integer> {

    List<MunicipioEntity> findByDepartamentoId(Integer departamentoId);

}
