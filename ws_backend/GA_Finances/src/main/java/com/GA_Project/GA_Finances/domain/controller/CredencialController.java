package com.GA_Project.GA_Finances.domain.controller;

import com.GA_Project.GA_Finances.domain.service.CredencialService;
import com.GA_Project.GA_Finances.entity.financeiroEntity.Transacao;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CredencialController {
    private final CredencialService credencialService;

    public CredencialController(CredencialService credencialService) {
        this.credencialService = credencialService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Credencial> cadastrarCredencial(@RequestBody Credencial credencial){
        Credencial response = credencialService.salvarCredencial(credencial);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login")
    public ResponseEntity<Credencial> logar(@RequestBody Credencial login){
        Credencial response = credencialService.login(login);
        return ResponseEntity.ok(response);
    }

    //aqui ele vai inserir o email e dar submit para gerar o token
    @PostMapping("/cadastro/recuperar_senha")
    public ResponseEntity<String>  gerarToken(@RequestBody Credencial login){
        credencialService.gerarToken(login);
        return ResponseEntity.ok("token gerado caso email esteja correto");
    }

    //aqui ele vai so inserir o token e tchal
    @GetMapping("/cadastro/validarToken")
    public ResponseEntity<Credencial> validarToken(@RequestBody Credencial credencial){
        Credencial response = credencialService.validarToken(credencial);
        return ResponseEntity.ok(response);
    }
}
