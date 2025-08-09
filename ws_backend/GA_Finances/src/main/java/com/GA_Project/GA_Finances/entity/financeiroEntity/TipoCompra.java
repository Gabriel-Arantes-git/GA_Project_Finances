package com.GA_Project.GA_Finances.entity.financeiroEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tipo_compra",schema = "financeiro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TipoCompra   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tipoCompra_seq")
    @SequenceGenerator(name = "tipoCompra_seq",sequenceName = "tipoCompra_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Column(name = "descricao")
    private String descricao;
}
