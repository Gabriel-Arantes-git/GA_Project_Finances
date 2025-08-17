package com.GA_Project.GA_Finances.domain.controller;

import com.GA_Project.GA_Finances.domain.service.TransacaoService;
import com.GA_Project.GA_Finances.dto.financeiro.ResponseResumoFinanceiroDTO;
import com.GA_Project.GA_Finances.entity.financeiroEntity.Transacao;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service){
        this.service = service;
    }

    @PostMapping("/adicionar_transferencia/{id}")
    public ResponseEntity<String> adicionarTransferencia(@Param("id") Long idkeyUsuario, @RequestBody Transacao novaTransacao){
        service.salvarTransacao(idkeyUsuario,novaTransacao);

        return ResponseEntity.ok("Transação Salva com Sucesso");
    }

    @GetMapping("/gastos-despesas/{id}")
    public ResponseEntity<ResponseResumoFinanceiroDTO> verificarGanhosDespesas(@Param("id") Long idkeyUsuario){
        Double ganho = service.calculoGanhosPorUsuario(idkeyUsuario);
        Double despesa = service.calculoGanhosPorUsuario(idkeyUsuario);
        Double saldoFinal = ganho - despesa;
        return ResponseEntity.ok(new ResponseResumoFinanceiroDTO(ganho,despesa,saldoFinal));
    }
}
