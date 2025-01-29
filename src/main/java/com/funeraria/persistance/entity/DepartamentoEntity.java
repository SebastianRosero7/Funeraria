package com.funeraria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter @Setter
@Entity
@Table(name="departamento")
public class DepartamentoEntity {

    @Id
    @Column(name="dep_codigo")
    private Integer id;

    @Column( name="dep_nombre",nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "departamentoEntity", orphanRemoval = true)
    private List<MunicipioEntity> municipioEntities;

}
