package com.funeraria.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name="departamento")
public class DepartamentoEntity {

    @Id
    @Column(name="dep_codigo")
    private Integer id;

    @Column( name="dep_nombre")
    private String nombre;

}
