package com.funeraria.persistance.jpa;

import com.funeraria.persistance.entity.FunerariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IFunerariaRepositoryCRUD  extends JpaRepository<FunerariaEntity,Integer> {
    Optional<FunerariaEntity> findByNombre(String nombre);
    Optional<FunerariaEntity> findByEmail(String email);
}
