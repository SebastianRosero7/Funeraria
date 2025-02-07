package com.funeraria.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConvenioDto {

    private int nit;
    private String empresa;
    private String direcion;
    private String telefono;
    private String titular;
    private String cedula;
    private Integer funerariaId;

}
