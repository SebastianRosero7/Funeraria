package com.funeraria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Table(name = "cliente")
@Entity
public class ClienteEntity {

    @Id
    @Column(name = "cli_cedula")
    private Integer cedula;

    @Column(name = "cli_nombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "cli_apellido", length = 20, nullable = false)
    private String apellido;

    @Column(name = "cli_fechanac", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "funerariaid_funeraria")
    private Integer funerariaId;

    @Column(name = "mun_codigo")
    private Integer municipioId;


    @ManyToOne
    @JoinColumn(name = "funerariaid_funeraria", insertable = false, updatable = false)
    private FunerariaEntity funerariaEntity;


    @ManyToOne
    @JoinColumn(name = "mun_codigo",insertable = false, updatable = false)
    private MunicipioEntity municipioEntity;

}
