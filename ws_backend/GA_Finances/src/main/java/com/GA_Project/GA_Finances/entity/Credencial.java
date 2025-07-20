package com.GA_Project.GA_Finances.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name = "credencial")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idkey;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "ultimo_login")
    private LocalDateTime ultimo_login;

    @Column(name = "ativo")
    @CreationTimestamp
    private Boolean ativo;

}
