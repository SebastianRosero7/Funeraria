package com.funeraria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "titular")
public class TitularEntity {

    @Id
    @Column(name = "tit_codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tit_direccion", length = 20, nullable = false)
    private String direccion;

    @Column(name = "tit_telefono", length = 10, nullable = false)
    private String telefono;

    @Column(name = "tit_barrio", length = 20, nullable = false)
    private String barrio;

    @Column(name = "cli_cedula")
    private String cedulaCliente;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cli_cedula",insertable = false, updatable = false)
    private ClienteEntity clienteEntity;

}
