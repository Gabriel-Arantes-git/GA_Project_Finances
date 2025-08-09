package com.GA_Project.GA_Finances.domain.controller;

import com.GA_Project.GA_Finances.domain.service.CredencialService;
import com.GA_Project.GA_Finances.entity.financeiroEntity.Transacao;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
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

    @GetMapping("/logar")
    public ResponseEntity<Credencial> logar(@RequestBody Credencial login){
        Credencial response = credencialService.login(login);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/gerar_token")
    public ResponseEntity<String>  gerarToken(@RequestBody Credencial login){
        credencialService.gerarToken(login);
        return ResponseEntity.ok("token gerado caso email esteja correto");
    }
}
