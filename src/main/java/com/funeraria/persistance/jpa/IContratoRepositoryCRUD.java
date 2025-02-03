package com.funeraria.persistance.jpa;

import com.funeraria.persistance.entity.ContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IContratoRepositoryCRUD extends JpaRepository<ContratoEntity,String> {
    List<ContratoEntity> findByTipoContrato(String tipoContrato);
    List<ContratoEntity> findByAfiliacion(Integer afiliacion);
    List<ContratoEntity> findByFechaContrato(LocalDate fechaContrato);
    List<ContratoEntity> findByTitularId(Integer titularId);
    List<ContratoEntity> findByFunerariaId(Integer funerariaId);

}
