package com.GA_Project.GA_Finances.entity.financeiroEntity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "parcela",schema = "financeiro")
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Parcela   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "parcela_seq")
    @SequenceGenerator(name = "parcela_seq",sequenceName = "parcela_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Column(name = "numero_parcela")
    private Double numeroParcela;

    @Column(name = "data_vencimento")
    private LocalDateTime dataVencimento;

    private Double valor;

    @OneToOne
    @JoinColumn(name = "idkey_status_pagamento",nullable = false)
    private StatusPagamento statusPagamento;

    @ManyToOne
    @JoinColumn(name = "idkey_transacao",nullable = false)
    private Transacao transacao;

}
