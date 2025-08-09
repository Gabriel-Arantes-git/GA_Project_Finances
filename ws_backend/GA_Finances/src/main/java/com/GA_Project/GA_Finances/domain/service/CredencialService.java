package com.GA_Project.GA_Finances.domain.service;

import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import com.GA_Project.GA_Finances.domain.repositories.CredencialRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CredencialService {

    private final CredencialRepository repository;

    public CredencialService(CredencialRepository repository){
        this.repository = repository;
    }

    public Credencial salvarCredencial(Credencial login){
        repository.saveAndFlush(login);
        return login;
    }

    public Credencial procurarUsuarioPorToken(String token){

        return repository.findByToken(token).orElseThrow(
                () -> new RuntimeException("Token Não Encontrado")
        );
    }

    public Credencial procurarUsuarioPorEmail(String email){

        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email Não Encontrado")
        );
    }

    @Transactional
    public void atualizarSenhaPorToken(String email,String novaSenha){
        Credencial credencial = procurarUsuarioPorToken(email);
        credencial.setSenha((novaSenha));//falta criptografia
        credencial.setUltima_alteracao(LocalDateTime.now());

    }

    @Transactional
    public void atualizarEmail(String antigoEmail,String novoEmail){
        Credencial credencial = procurarUsuarioPorEmail(antigoEmail);
        credencial.setEmail(novoEmail);
        credencial.setUltima_alteracao(LocalDateTime.now());
    }
}
