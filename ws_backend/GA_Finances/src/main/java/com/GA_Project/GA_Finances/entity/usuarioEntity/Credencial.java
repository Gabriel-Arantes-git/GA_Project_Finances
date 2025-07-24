package com.GA_Project.GA_Finances.entity.usuarioEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "credencial")
@Entity
@Data
public class Credencial implements EntidadePadrao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credencial_seq")
    @SequenceGenerator(name = "credencial_seq",sequenceName = "credencial_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "ultimo_login")
    @CreationTimestamp
    private LocalDateTime ultimo_login;

    @Column(name = "ativo")
    private Boolean ativo;

}
