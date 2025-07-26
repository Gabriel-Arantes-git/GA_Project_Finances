package com.GA_Project.GA_Finances.service;

import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import com.GA_Project.GA_Finances.repositories.CredencialRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CredencialService {

    private final CredencialRepository repository;

    public CredencialService(CredencialRepository repository){
        this.repository = repository;
    }

    public void salvarCredencial(Credencial login){
        repository.saveAndFlush(login);
    }

    public UserDetails procurarUsuarioPorEmail(String email){

        return repository.procurarPorEmail(email).orElseThrow(
                () -> new RuntimeException("Email Não Encontrado")
        );
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deletarPorEmail(email);
    }

    public void atualizarUsuarioPorEmail(String email){
        //falta implementar
    }


}
