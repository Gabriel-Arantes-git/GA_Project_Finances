package com.GA_Project.GA_Finances.domain.controller;

import com.GA_Project.GA_Finances.domain.service.TransacaoService;
import com.GA_Project.GA_Finances.dto.financeiro.RequestNovaTransacaoDTO;
import com.GA_Project.GA_Finances.dto.financeiro.ResponseResumoFinanceiroDTO;
import com.GA_Project.GA_Finances.entity.financeiroEntity.Transacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service){
        this.service = service;
    }

    @PostMapping("/adicionar_transferencia/{id}")
    public ResponseEntity<Transacao> adicionarTransferencia(@PathVariable("id") Long idkeyUsuario, @RequestBody RequestNovaTransacaoDTO novaTransacao){


        return ResponseEntity.ok( service.salvarTransacao(idkeyUsuario,novaTransacao));
    }

    @GetMapping("/gastos-despesas/{id}")
    public ResponseEntity<ResponseResumoFinanceiroDTO> verificarGanhosDespesas(@PathVariable("id") Long idkeyUsuario){
        Double ganho = service.calculoGanhosPorUsuario(idkeyUsuario);
        Double despesa = service.calculoDespesasPorUsuario(idkeyUsuario);
        Double saldoFinal = ganho - despesa;
        return ResponseEntity.ok(new ResponseResumoFinanceiroDTO(ganho,despesa,saldoFinal));
    }

    @GetMapping("usuario/{id}/transacoes")
    public ResponseEntity<List<Transacao>> buscarTransacoesPorUsuario(@PathVariable("id") Long idkeyUsuario){

        return ResponseEntity.ok(service.buscarTransacaoPorUsuario(idkeyUsuario));
    }
}
