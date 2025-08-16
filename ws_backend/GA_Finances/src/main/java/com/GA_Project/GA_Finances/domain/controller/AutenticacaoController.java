package com.GA_Project.GA_Finances.domain.controller;

import com.GA_Project.GA_Finances.domain.service.CredencialService;
import com.GA_Project.GA_Finances.domain.service.UsuarioService;
import com.GA_Project.GA_Finances.dto.usuario.RequestUsuarioDTO;
import com.GA_Project.GA_Finances.dto.usuario.ResponseUsuarioDTO;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutenticacaoController {

    private final CredencialService credencialService;
    private final UsuarioService usuarioService;

    public AutenticacaoController(CredencialService credencialService,UsuarioService usuarioService) {
        this.credencialService = credencialService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public ResponseEntity<ResponseUsuarioDTO> logar(@RequestBody Credencial login){
        Usuario response = credencialService.login(login);
        ResponseUsuarioDTO responseDTO = new ResponseUsuarioDTO(response.getIdkey(),response.getNome());
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ResponseUsuarioDTO> salvarUsuario(@RequestBody @Valid RequestUsuarioDTO usuario){
        Usuario response = usuarioService.salvarUsuario(usuario);

        ResponseUsuarioDTO responseDTO = new ResponseUsuarioDTO(response.getIdkey(),response.getNome());
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/cadastro/recuperar_senha")
    public ResponseEntity<String>  gerarToken(@RequestBody Credencial login){
        credencialService.gerarToken(login);
        return ResponseEntity.ok("token gerado caso email esteja correto");
    }

    @PostMapping("/cadastro/validarToken")
    public ResponseEntity<Credencial> validarToken(@RequestBody Credencial credencial){
        Credencial response = credencialService.validarToken(credencial);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastro/novo_email/{id}")
    public ResponseEntity<String> atualizarEmail(@PathVariable Long id,@RequestBody String email){
        credencialService.alterarEmail(id,email);
        return ResponseEntity.ok("email atualizado");
    }
    @PostMapping("/cadastro/nova_senha/{id}")
    public ResponseEntity<String> atualizarSenha(@PathVariable Long id,@RequestBody String senha){
        credencialService.alterarSenha(id,senha);
        return ResponseEntity.ok("senha atualizado");
    }
}
