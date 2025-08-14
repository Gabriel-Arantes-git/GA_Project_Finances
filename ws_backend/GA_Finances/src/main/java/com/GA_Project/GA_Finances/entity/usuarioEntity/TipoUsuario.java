package com.GA_Project.GA_Finances.entity.usuarioEntity;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "tipo_usuario",schema = "usuario")
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TipoUsuario   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoUsuario_seq")
    @SequenceGenerator(name = "tipoUsuario_seq",sequenceName = "tipoUsuario_idkey_seq",allocationSize = 1)
    private Long idkey;

    @Enumerated(EnumType.STRING)
    @Column(name = "descricao")
    private UserTipo descricao;
}
