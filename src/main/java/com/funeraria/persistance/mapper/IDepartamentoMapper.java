package com.funeraria.persistance.mapper;

import com.funeraria.domain.pojo.DepartamentoPojo;
import com.funeraria.persistance.entity.DepartamentoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma objetos de tipo Departamento
 * a pojos o Entitys
 */
@Mapper(componentModel = "spring")
public interface IDepartamentoMapper {

    /**
     * Convierte una Entity a un pojo de Departamento
     * se usa el Mapping para aclarar el nombre de los parametros,
     * si tienen el mismo nombre no es necesario usarlo
     * @param departamentoEntity entidad que se va a convertir
     * @return Pojo convertido
     */
    //@Mapping(source = "id",target = "id")
    //@Mapping(source = "nombre",target = "nombre")
    DepartamentoPojo toDepartamentoPojo(DepartamentoEntity departamentoEntity);

    /**
     * Convierte un Pojo a una Entity
     * @param departamentoPojo Pojo que se va a convertir
     * @return Entity convertida
     */
    @InheritInverseConfiguration
    DepartamentoEntity toDepartamentoEntity(DepartamentoPojo departamentoPojo);

    /**
     * Converts a list of DepartamentoEntity objects to a list of DepartamentoPojo objects.
     *
     * @param departamentoEntity the list of DepartamentoEntity objects to be converted
     * @return a list of converted DepartamentoPojo objects
     */
    List<DepartamentoPojo> toDepartamentosPojo(List<DepartamentoEntity> departamentoEntity);


}
