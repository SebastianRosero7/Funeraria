package com.funeraria.persistance.jpa;

import com.funeraria.persistance.entity.DesignadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IDesignadoRepositoryCRUD extends JpaRepository<DesignadoEntity,Integer> {

    List<DesignadoEntity> findByParentesco(String parentesco);
    Optional<DesignadoEntity> findByCedulaCliente(String cedulaCliente);
    List<DesignadoEntity> findByNumeroContrato(String numeroContrato);
    void deleteByCedulaCliente(String cedulaCliente);
    void deleteByNumeroContrato(String numeroContrato);

}
