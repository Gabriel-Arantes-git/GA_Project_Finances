package com.GA_Project.GA_Finances.entity.usuarioEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Table(name = "credencial",schema = "usuario")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Credencial implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credencial_seq")
    @SequenceGenerator(name = "credencial_seq",sequenceName = "credencial_idkey_seq",allocationSize = 1,schema = "usuario")
    private Long idkey;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "ultimo_login")
    @CreationTimestamp
    private LocalDateTime ultimo_login;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column
    private LocalDateTime ultima_alteracao;

    @Column(name = "token_recuperacao")
    private String token;

    @Column(name = "token_criacao")
    private LocalDateTime tokenCriacao;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
