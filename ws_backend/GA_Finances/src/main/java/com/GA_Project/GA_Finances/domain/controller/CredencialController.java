package com.GA_Project.GA_Finances.domain.controller;

import com.GA_Project.GA_Finances.domain.service.CredencialService;
import com.GA_Project.GA_Finances.entity.financeiroEntity.Transacao;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastrar")
public class CredencialController {
    private final CredencialService credencialService;

    public CredencialController(CredencialService credencialService) {
        this.credencialService = credencialService;
    }

    @PostMapping
    public ResponseEntity<Credencial> cadastrarCredencial(@RequestBody Credencial credencial){
        Credencial response = credencialService.salvarCredencial(credencial);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Credencial> buscarPorEmail(@PathVariable String email){
        Credencial response = credencialService.procurarUsuarioPorEmail(email);
        return ResponseEntity.ok(response);
    }
}
