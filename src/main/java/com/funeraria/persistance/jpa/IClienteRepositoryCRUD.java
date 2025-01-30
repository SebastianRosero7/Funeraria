package com.funeraria.persistance.jpa;

import com.funeraria.persistance.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteRepositoryCRUD extends JpaRepository<ClienteEntity,Integer> {
    List<ClienteEntity> findByNombre(String nombre);
    List<ClienteEntity> findByApellido(String apellido);
}
