package com.funeraria.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class ClienteDto {

    private Integer cedula;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Integer funerariaId;
    private Integer municipioId;
}
