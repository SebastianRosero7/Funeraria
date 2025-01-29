package com.funeraria.persistance.jpa;

import com.funeraria.persistance.entity.MunicipioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMunicipioRepositoryCRUD extends JpaRepository<MunicipioEntity,Integer> {

    Optional<MunicipioEntity> findByDepartamentoId(Integer departamentoId);

}
