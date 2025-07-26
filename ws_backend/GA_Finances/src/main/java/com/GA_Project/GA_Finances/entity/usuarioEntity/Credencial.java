package com.GA_Project.GA_Finances.entity.usuarioEntity;

import com.GA_Project.GA_Finances.entity.EntidadePadrao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "credencial",schema = "usuario")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Credencial implements EntidadePadrao, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credencial_seq")
    @SequenceGenerator(name = "credencial_seq",sequenceName = "credencial_idkey_seq",allocationSize = 1)
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
