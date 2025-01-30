package com.funeraria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "municipio")
public class MunicipioEntity {

    @Id
    @Column(name = "mun_codigo")
    private Integer id;

    @Column(name = "mun_nombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "dep_codigo")
    private Integer departamentoId;

    @ManyToOne
    @JoinColumn(name = "dep_codigo", insertable = false, updatable = false)
    private DepartamentoEntity departamentoEntity;

    @OneToMany(mappedBy = "municipioEntity", orphanRemoval = true)
    private List<ClienteEntity> clienteEntities;

}
