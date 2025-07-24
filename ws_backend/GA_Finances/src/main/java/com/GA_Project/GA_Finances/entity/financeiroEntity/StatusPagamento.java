package com.GA_Project.GA_Finances.entity.financeiroEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "categoria")
@Data
@Entity
@NoArgsConstructor
public class StatusPagamento implements EntidadePadrao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "statusPagamento_seq")
    @SequenceGenerator(name = "statusPagamento_seq",sequenceName = "statusPagamento_idkey_seq",allocationSize = 1)
    private Long idkey;

    private String descricao;

}
