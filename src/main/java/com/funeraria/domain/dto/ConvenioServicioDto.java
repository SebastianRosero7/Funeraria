package com.funeraria.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConvenioServicioDto {

    private Integer id;
    private Integer idConvenio;
    private String idServicio;
    private String fallecido;
    private String cedula;
    private Double valorCaja;
    private Double valorTransporte;
    private Double valorexcedente;
}
