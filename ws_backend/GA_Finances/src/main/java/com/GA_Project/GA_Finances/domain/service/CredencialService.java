package com.GA_Project.GA_Finances.domain.service;

import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import com.GA_Project.GA_Finances.domain.repositories.CredencialRepository;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class CredencialService {

    private final CredencialRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final SecureRandom random = new SecureRandom();

    @Autowired
    private EmailService emailService;

    public CredencialService(CredencialRepository repository,
                             PasswordEncoder passwordEncoder,
                             EmailService emailService){
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
        this.emailService = emailService;
    }


    @Transactional
    public Credencial salvarCredencial(Credencial novaCredencial){

        repository.findByEmail(novaCredencial.getEmail()).ifPresent(credencial -> {
            throw new IllegalStateException("Email já existente");
        });
        novaCredencial.setSenha(passwordEncoder.encode(novaCredencial.getPassword()));
        novaCredencial.setAtivo(true);

        return repository.save(novaCredencial);
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

    public Usuario login(Credencial dados){
        Credencial credencialSalva = repository.findByEmail(dados.getEmail())
                .orElseThrow(() -> new RuntimeException("Login ou Senha incorreta"));

        if(passwordEncoder.matches(dados.getPassword(), credencialSalva.getPassword())){
            return repository.findUserByIdkeyCredencial(credencialSalva.getIdkey())
                    .orElseThrow(()-> new RuntimeException("Erro ao encontrar Usuário"));
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



}
