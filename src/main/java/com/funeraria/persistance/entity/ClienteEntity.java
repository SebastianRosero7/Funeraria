package com.funeraria.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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


    private Integer funerariaId;


    private Integer municipioId;
}
