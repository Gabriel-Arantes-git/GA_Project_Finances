package com.GA_Project.GA_Finances.domain.service;

import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import com.GA_Project.GA_Finances.domain.repositories.CredencialRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public void gerarToken(Credencial dados){
        Credencial credencial = repository.findByEmail(dados.getEmail()).orElseThrow(() -> new RuntimeException("email invalido"));

        credencial.setToken("1234");
        credencial.setTokenCriacao(LocalDateTime.now());
        repository.save(credencial);
    }

    public Credencial login(Credencial dados){
        Credencial credencial = repository.findByEmail(dados.getEmail())
                .orElseThrow(() -> new RuntimeException("Login ou Senha incorreta"));

        if(credencial.getPassword().equals(dados.getPassword())){
            return credencial;
        }
        else{
            throw new RuntimeException("Login ou Senha incorreta");
        }

    }

    @Transactional
    public void atualizarSenhaPorToken(String email,String novaSenha){
        Credencial credencial = procurarUsuarioPorToken(email);
        credencial.setSenha((novaSenha));//falta criptografia
        credencial.setUltima_alteracao(LocalDateTime.now());

    }

    @Transactional
    public void atualizarEmail(Credencial loginAntigo,String novoEmail){
        Credencial credencial = login(loginAntigo);
        credencial.setEmail(novoEmail);
        credencial.setUltima_alteracao(LocalDateTime.now());
    }
}
