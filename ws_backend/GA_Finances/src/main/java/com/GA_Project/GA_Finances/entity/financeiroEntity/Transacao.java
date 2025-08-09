package com.GA_Project.GA_Finances.entity.financeiroEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "transacao",schema = "financeiro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transacao   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transacao_seq")
    @SequenceGenerator(name = "transacao_seq",sequenceName = "transacao_idkey_seq",allocationSize = 1)
    private Long idkey;

    private String nome;

    private Double valor;

    private LocalDateTime data;

    @OneToOne
    @JoinColumn(name = "idkey_categoria",nullable = false)
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "idkey_tipoTransacao",nullable = false)
    private TipoTransacao tipoTransacao;

    @OneToOne
    @JoinColumn(name = "idkey_tipoCompra",nullable = false)
    private TipoCompra tipoCompra;

    @OneToOne
    @JoinColumn(name = "idkey_nivel_prioridade",nullable = false)
    private NivelPrioridade nivelPrioridade;


}
