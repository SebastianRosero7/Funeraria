package com.funeraria.persistance.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "convenio")
public class ConvenioEntity {

    @Id
    @Column(name = "conv_nit")
    private int nit;

    @Column(name = "conv_empresa", nullable = false, length = 30)
    private String empresa;

    @Column(name = "conv_direccion", nullable = false, length = 20)
    private String direcion;

    @Column(name = "conv_telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "conv_titular", nullable = false, length = 25)
    private String titular;

    @Column(name = "conv_cedula", nullable = false, length = 10)
    private String cedula;

    @Column(name = "funerariaid_funeraria", nullable = false)
    private Integer funerariaId;

    @ManyToOne
    @JoinColumn(name = "funerariaid_funeraria",insertable = false, updatable = false)
    private FunerariaEntity funerariaEntity;

}