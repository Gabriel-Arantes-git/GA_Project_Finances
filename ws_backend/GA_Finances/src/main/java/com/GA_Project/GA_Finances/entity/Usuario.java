package com.GA_Project.GA_Finances.entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Table(name = "usuario")
@Entity

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idkey;

    @Column(name = "nome")
    private String nome;

    @OneToOne
    @JoinColumn(name = "idkey_credencial",nullable = false)
    private Credencial credencial;

}
