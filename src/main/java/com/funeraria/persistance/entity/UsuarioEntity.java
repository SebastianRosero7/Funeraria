package com.funeraria.persistance.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer id;

    @Column(name = "usuario", nullable = false, length = 10)
    private String usuario;

    @Column(name = "contrasena", nullable = false, length = 20)
    private String contrasena;

    @Column(name = "tipo", nullable = false)
    private Integer tipoUsuario;

    @Column(name = "funerariaid_funeraria")
    private Integer funerariaId;


    @OneToOne
    @JoinColumn(name = "funerariaid_funeraria",insertable = false, updatable = false)
    private FunerariaEntity funerariaEntity;

}
