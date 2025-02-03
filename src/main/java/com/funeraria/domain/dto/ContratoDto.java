package com.funeraria.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class ContratoDto {

    private String id;
    private String tipoContrato;
    private Integer afiliacion;
    private Integer mensualidad;
    private LocalDate fechaContrato;
    private Integer titularId;
    private Integer funerariaId;
}
