package com.funeraria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@Table(name = "contrato")
public class ContratoEntity {

    @Id
    @Column(name = "cont_numero")
    private String id;

    @Column(name = "cont_tipo",length = 10,nullable = false)
    private String tipoContrato;

    @Column(name = "cont_afiliacion",nullable = false)
    private Integer afiliacion;

    @Column(name = "cont_mensualidad",nullable = false)
    private Integer mensualidad;

    @Column(name = "cont_fecha",nullable = false)
    private LocalDate fechaContrato;

    @Column(name = "tit_codigo")
    private Integer titularId;

    @Column(name = "funerariaid_funeraria")
    private Integer funerariaId;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "tit_codigo",insertable = false, updatable = false)
    private TitularEntity titularEntity;

    @ManyToOne
    @JoinColumn(name = "funerariaid_funeraria",insertable = false, updatable = false)
    private FunerariaEntity funerariaEntity;

}
