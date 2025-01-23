package com.funeraria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "funeraria")
public class FunerariaEntity {

    @Id
    @Column(name = "id_funeraria")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;


    @OneToOne(mappedBy = "funerariaEntity", orphanRemoval = true)
    private UsuarioEntity usuarioEntity;

}
