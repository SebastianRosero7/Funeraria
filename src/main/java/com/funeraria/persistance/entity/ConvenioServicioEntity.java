package com.funeraria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "convenio_servicio")
public class ConvenioServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "convserv_id")
    private Integer id;

    @Column(name = "conv_nit", nullable = false)
    private Integer idConvenio;

    @Column(name = "serv_codigo",nullable = false)
    private String idServicio;

    @Column(name = "conv_fallecido",nullable = false,length = 35)
    private String fallecido;

    @Column(name = "conv_cedulafallecido",nullable = false,length = 15)
    private String cedula;

    @Column(name = "conv_valorcaja",nullable = false,length = 9)
    private Double valorCaja;

    @Column(name = "conv_valortransporte",nullable = false,length = 9)
    private Double valorTransporte;

    @Column(name = "conv_excedente",nullable = false,length = 10)
    private Double valorexcedente;

    @ManyToOne
    @JoinColumn(name = "conv_nit",insertable = false, updatable = false)
    private ConvenioEntity convenioEntity;

    //referencia a servicio falta

}
