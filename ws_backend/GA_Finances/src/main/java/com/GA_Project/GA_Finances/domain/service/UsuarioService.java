package com.GA_Project.GA_Finances.domain.service;

import com.GA_Project.GA_Finances.domain.repositories.usuario.UsuarioRepository;
import com.GA_Project.GA_Finances.dto.usuario.RequestUsuarioDTO;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import com.GA_Project.GA_Finances.entity.usuarioEntity.TipoUsuario;
import com.GA_Project.GA_Finances.entity.usuarioEntity.UserTipo;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final CredencialService credencialService;

    public UsuarioService(UsuarioRepository repository,CredencialService credencialService){
        this.repository = repository;
        this.credencialService = credencialService;
    }

    @Transactional
    public Usuario salvarUsuario(RequestUsuarioDTO usuario){
        Credencial novaCredencial = credencialService.salvarCredencial(new Credencial(usuario.email(), usuario.senha()));
        Usuario novoUsuario = new Usuario();

        novoUsuario.setNome(usuario.nome());
        novoUsuario.setTipoUsuario(new TipoUsuario((long)2, UserTipo.USER));
        novoUsuario.setCredencial(novaCredencial);

        return repository.save(novoUsuario);
    }

    public Usuario buscarUsuarioById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("usuario invalido"));
    }
}
