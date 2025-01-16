package com.funeraria.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="Departamento")
public class DepartamentoEntity {
    @Id
    @Column(name="Dep_codigo")
    private Integer codDepartamento;

    @Column( name="Dep_nombre")
    private String nombre;

}
