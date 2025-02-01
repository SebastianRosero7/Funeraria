package com.funeraria.persistance.jpa;


import com.funeraria.persistance.entity.TitularEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITitularRepositoryCRUD extends JpaRepository<TitularEntity,Integer> {

    Optional<TitularEntity> findByCedulaCliente(String cedulaCliente);
    void deleteByCedulaCliente(String cedulaCliente);
}
