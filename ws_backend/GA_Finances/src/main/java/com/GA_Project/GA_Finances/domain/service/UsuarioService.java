package com.GA_Project.GA_Finances.domain.service;

import com.GA_Project.GA_Finances.domain.repositories.UsuarioRepository;
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
    public Usuario salvarUsuario(Usuario usuario){
        Credencial novaCredencial = credencialService.salvarCredencial(usuario.getCredencial());

        if (usuario.getTipoUsuario() == null) {
            usuario.setTipoUsuario(new TipoUsuario((long)2, UserTipo.USER));
        }
        usuario.setCredencial(novaCredencial);
        return repository.save(usuario);
    }
}
