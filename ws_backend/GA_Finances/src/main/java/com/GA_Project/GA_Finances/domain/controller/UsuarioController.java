package com.GA_Project.GA_Finances.domain.controller;

import com.GA_Project.GA_Finances.domain.service.UsuarioService;
import com.GA_Project.GA_Finances.dto.usuario.RequestUsuarioDTO;
import com.GA_Project.GA_Finances.dto.usuario.ResponseUsuarioDTO;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){this.usuarioService = usuarioService;}

    @PostMapping("/cadastrar/usuario")
    public ResponseEntity<ResponseUsuarioDTO> salvarUsuario(@RequestBody @Valid RequestUsuarioDTO usuario){
        Usuario response = usuarioService.salvarUsuario(usuario);

        ResponseUsuarioDTO responseDTO = new ResponseUsuarioDTO(response.getIdkey(),response.getNome());
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/homepage/{id}")
    public ResponseEntity<ResponseUsuarioDTO> buscarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarUsuarioById(id);
        return ResponseEntity.ok(new ResponseUsuarioDTO(usuario.getIdkey(),usuario.getNome()));
    }
}
