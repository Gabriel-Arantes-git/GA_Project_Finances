package com.GA_Project.GA_Finances.domain.service;

import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import com.GA_Project.GA_Finances.domain.repositories.CredencialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CredencialService {

    private final CredencialRepository repository;

    private final SecureRandom random = new SecureRandom();

    @Autowired
    private EmailService emailService;

    public CredencialService(CredencialRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Credencial salvarCredencial(Credencial login){
        repository.saveAndFlush(login);
        return login;
    }

    public Credencial procurarUsuarioPorToken(String token){

        return repository.findByToken(token).orElseThrow(
                () -> new RuntimeException("Token Não Encontrado")
        );
    }

    @Transactional
    public void gerarToken(Credencial dados){
        Credencial credencial = repository.findByEmail(dados.getEmail()).orElseThrow(() -> new RuntimeException("email invalido"));

        int numero = random.nextInt(1_000_000);

        credencial.setToken(String.format("%06d", numero));
        credencial.setTokenCriacao(LocalDateTime.now());
        repository.save(credencial);

        emailService.enviarTokenRecuperacao(credencial.getToken(), credencial.getEmail());
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

    public Credencial validarToken(Credencial credencialRecuperarSenha) {
        Credencial dadosCadastrados = repository.findByEmail(credencialRecuperarSenha.getEmail())
                .orElseThrow(() -> new RuntimeException("Email não encontrado"));

        if (!dadosCadastrados.getToken().equals(credencialRecuperarSenha.getToken())) {
            throw new RuntimeException("Token inválido");
        }

        if (dadosCadastrados.getTokenCriacao().plusMinutes(5).isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expirado");
        }

        return dadosCadastrados;
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
