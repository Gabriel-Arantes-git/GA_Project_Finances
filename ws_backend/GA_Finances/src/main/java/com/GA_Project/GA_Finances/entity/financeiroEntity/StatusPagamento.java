package com.GA_Project.GA_Finances.entity.financeiroEntity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "status_pagamento",schema = "financeiro")
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class StatusPagamento   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "statusPagamento_seq")
    @SequenceGenerator(name = "statusPagamento_seq",sequenceName = "statusPagamento_idkey_seq",allocationSize = 1)
    private Long idkey;

    private String descricao;

}
