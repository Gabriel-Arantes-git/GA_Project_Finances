package com.GA_Project.GA_Finances.entity.usuarioEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import com.GA_Project.GA_Finances.entity.financeiroEntity.Transacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "usuario",schema = "usuario")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Usuario implements EntidadePadrao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq",sequenceName = "usuario_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Column(name = "nome")
    private String nome;

    @OneToOne
    @JoinColumn(name = "idkey_credencial",nullable = false)
    private Credencial credencial;

    @OneToOne
    @JoinColumn(name = "idkey_tipo_usuario",nullable = false)
    private TipoUsuario tipoUsuario;

    @ManyToMany
    @JoinTable(name = "tpl_transacao_usuario",
        joinColumns = @JoinColumn(name = "idkey_usuario"),
        inverseJoinColumns = @JoinColumn(name = "idkey_transacao")
    )
    private List<Transacao> transacoes;

}
