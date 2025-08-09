package com.GA_Project.GA_Finances.entity.financeiroEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "categoria",schema = "financeiro")
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
public class Categoria   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "categoria_seq")
    @SequenceGenerator(name = "categoria_seq",sequenceName = "categoria_idkey_seq",allocationSize = 1)
    private Long idkey;

    private String nome;

    @OneToOne
    @JoinColumn(name = "idkey_tipo_categoria",nullable = false)
    private TipoCategoria tipoCategoria;

    @OneToOne
    @JoinColumn(name = "idkey_usuario")
    private Usuario usuario;
}
