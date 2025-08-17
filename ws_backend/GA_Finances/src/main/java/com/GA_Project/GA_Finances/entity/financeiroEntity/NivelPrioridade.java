package com.GA_Project.GA_Finances.entity.financeiroEntity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "nivel_prioridade",schema = "financeiro")
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class NivelPrioridade   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nivelPrioridade_seq")
    @SequenceGenerator(name = "nivelPrioridade_seq",sequenceName = "nivelPrioridade_idkey_seq",allocationSize = 1)
    private Long idkey;

    private String descricao;


}
