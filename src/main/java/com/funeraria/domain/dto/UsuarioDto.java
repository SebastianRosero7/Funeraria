package com.funeraria.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioDto {

    private Integer id;
    private String usuario;
    private String contrasena;
    private Integer tipoUsuario;
    private Integer funerariaId;

}
