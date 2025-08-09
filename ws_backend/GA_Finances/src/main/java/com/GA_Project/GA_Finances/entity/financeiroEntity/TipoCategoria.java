package com.GA_Project.GA_Finances.entity.financeiroEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tipo_categoria",schema = "financeiro")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class TipoCategoria   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tipoCategoria_seq")
    @SequenceGenerator(name = "tipoCategoria_seq",sequenceName = "tipoCategoria_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Column(name = "descricao")
    private String descricao;

}
