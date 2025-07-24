package com.GA_Project.GA_Finances.entity.financeiroEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tipo_compra")
@Data
@NoArgsConstructor
@Entity
public class TipoCompra implements EntidadePadrao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tipoCompra_seq")
    @SequenceGenerator(name = "tipoCompra_seq",sequenceName = "tipoCompra_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Column(name = "descricao")
    private String descricao;
}
