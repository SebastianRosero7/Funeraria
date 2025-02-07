package com.funeraria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "funeraria")
public class FunerariaEntity {

    @Id
    @Column(name = "id_funeraria")
    private Integer id;

    @Column(name = "nombre",length = 255,nullable = false,unique = true)
    private String nombre;

    @Column(name = "direccion",length = 255,nullable = false)
    private String direccion;
    @Column(name = "email",length = 50,unique = true)
    private String email;
    @Column(name = "telefono",length = 50)
    private String telefono;


    @OneToOne(mappedBy = "funerariaEntity", orphanRemoval = true)
    private UsuarioEntity usuarioEntity;

    @OneToMany(mappedBy = "funerariaEntity", orphanRemoval = true)
    private List<ClienteEntity> clienteEntities;

    @OneToMany(mappedBy = "funerariaEntity", orphanRemoval = true)
    private List<ContratoEntity> contratoEntities;

    @OneToMany(mappedBy = "funerariaEntity", orphanRemoval = true)
    private List<ConvenioEntity> convenioEntities;

}
