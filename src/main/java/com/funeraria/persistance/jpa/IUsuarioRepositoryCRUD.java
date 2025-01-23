package com.funeraria.persistance.jpa;

import com.funeraria.persistance.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepositoryCRUD extends JpaRepository<UsuarioEntity,Integer> {

    Optional<UsuarioEntity> findByfunerariaId(Integer id);

}
