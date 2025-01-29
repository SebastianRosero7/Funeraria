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

    @Column(name = "nombre",length = 255,nullable = false)
    private String nombre;

    @Column(name = "direccion",length = 255,nullable = false)
    private String direccion;
    @Column(name = "email",length = 50)
    private String email;
    @Column(name = "telefono",length = 50)
    private String telefono;


    @OneToOne(mappedBy = "funerariaEntity", orphanRemoval = true)
    private UsuarioEntity usuarioEntity;

}
