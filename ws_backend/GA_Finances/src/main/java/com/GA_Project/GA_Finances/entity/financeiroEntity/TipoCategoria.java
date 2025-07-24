package com.GA_Project.GA_Finances.entity.financeiroEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tipo_categoria")
@NoArgsConstructor
@Data
@Entity
public class TipoCategoria implements EntidadePadrao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tipoCategoria_seq")
    @SequenceGenerator(name = "tipoCategoria_seq",sequenceName = "tipoCategoria_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Column(name = "descricao")
    private String descricao;

}
