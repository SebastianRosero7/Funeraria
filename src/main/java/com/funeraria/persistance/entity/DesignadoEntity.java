package com.funeraria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "designado")
public class DesignadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "des_codigo")
    private Integer id;

    @Column(name = "des_parentesco", nullable = false, length = 10)
    private String parentesco;

    @Column(name = "cli_cedula")
    private String cedulaCliente;

    @Column(name = "cont_numero")
    private String numeroContrato;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cli_cedula",insertable = false, updatable = false)
    private ClienteEntity clienteEntity;


    @ManyToOne
    @JoinColumn(name = "cont_numero",insertable = false, updatable = false)
    private ContratoEntity contratoEntity;

}
