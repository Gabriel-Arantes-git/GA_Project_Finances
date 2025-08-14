package com.GA_Project.GA_Finances.domain.controller;

import com.GA_Project.GA_Finances.domain.service.UsuarioService;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){this.usuarioService = usuarioService;}

    @PostMapping("/cadastrar/usuario")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
        Usuario response = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(response);
    }
}
