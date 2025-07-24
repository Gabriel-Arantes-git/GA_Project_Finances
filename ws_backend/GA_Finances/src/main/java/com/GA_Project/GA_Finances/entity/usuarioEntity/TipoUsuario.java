package com.GA_Project.GA_Finances.entity.usuarioEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "tipo_usuario")
@Entity
@NoArgsConstructor
@Data
public class TipoUsuario implements EntidadePadrao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoUsuario_seq")
    @SequenceGenerator(name = "tipoUsuario_seq",sequenceName = "tipoUsuario_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Column(name = "descricao")
    private UserTipo descricao;
}
