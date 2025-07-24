package com.GA_Project.GA_Finances.entity.financeiroEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "parcela")
@Data
@Entity
@NoArgsConstructor
public class Parcela implements EntidadePadrao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "parcela_seq")
    @SequenceGenerator(name = "parcela_seq",sequenceName = "parcela_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Column(name = "numero_parcela")
    private Double numeroParcela;

    @Column(name = "data_vencimento")
    private LocalDateTime dataVencimento;

    private Double valor;

    @JoinColumn(name = "idkey_status_pagamento",nullable = false)
    private StatusPagamento statusPagamento;


}
