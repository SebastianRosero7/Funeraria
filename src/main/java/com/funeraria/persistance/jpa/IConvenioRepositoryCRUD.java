package com.funeraria.persistance.jpa;

import com.funeraria.persistance.entity.ConvenioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IConvenioRepositoryCRUD extends JpaRepository<ConvenioEntity,Integer> {

    Optional<ConvenioEntity> findByEmpresa(String empresa);

    Optional<ConvenioEntity> findByTitular(String titular);

    Optional<ConvenioEntity> findByCedula(String cedula);

    List<ConvenioEntity> findByFunerariaId(Integer funerariaId);

    void deleteByCedula(String cedula);

}
