package com.GA_Project.GA_Finances.entity.financeiroEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tipo_transacao",schema = "financeiro")
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class TipoTransacao   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tipoCategoria_seq")
    @SequenceGenerator(name = "tipoCategoria_seq",sequenceName = "tipoCategoria_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Column(name = "descricao")
    private String descricao;
}
