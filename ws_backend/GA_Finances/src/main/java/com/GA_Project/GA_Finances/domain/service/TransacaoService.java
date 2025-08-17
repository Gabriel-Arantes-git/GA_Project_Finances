package com.GA_Project.GA_Finances.domain.service;

import com.GA_Project.GA_Finances.domain.repositories.TransacaoRepository;
import com.GA_Project.GA_Finances.domain.repositories.UsuarioRepository;
import com.GA_Project.GA_Finances.entity.financeiroEntity.Transacao;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransacaoService {

    private final TransacaoRepository repository;
    private final UsuarioRepository usuarioRepository;

    public TransacaoService(TransacaoRepository repository,UsuarioRepository usuarioRepository){
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Transacao> buscarTransacaoPorUsuario(Long idkeyUsuario){
        usuarioRepository.findById(idkeyUsuario)
                .orElseThrow(()-> new RuntimeException("id de usuario inválido"));

        return  repository.findByUsuario(idkeyUsuario);
    }

    public Usuario salvarTransacao(Long idkeyUsuario,Transacao novaTransacao){
        Usuario usuario = usuarioRepository.findById(idkeyUsuario)
                .orElseThrow(()-> new RuntimeException("id de usuario inválido"));

        Transacao transacaoSalva = repository.save(novaTransacao);

        usuario.addTransacao(transacaoSalva);

        return usuarioRepository.save(usuario);
    }
//to-do fazer a restricao por mes
    public Double calculoGanhosPorUsuario(Long idkeyUsuario){
        usuarioRepository.findById(idkeyUsuario)
                .orElseThrow(()-> new RuntimeException("id de usuario inválido"));
        Double valorTotal = 0.00;
        List<Transacao> transacoes = repository.findGanhosByUsuario(idkeyUsuario);

        for(Transacao transacao : transacoes){
            valorTotal += transacao.getValor();
        }

        return valorTotal;
    }

    public Double calculoDespesasPorUsuario(Long idkeyUsuario){
        usuarioRepository.findById(idkeyUsuario)
                .orElseThrow(()-> new RuntimeException("id de usuario inválido"));
        Double valorTotal = 0.00;
        List<Transacao> transacoes = repository.findDespesasByUsuario(idkeyUsuario);

        for(Transacao transacao : transacoes){
            valorTotal += transacao.getValor();
        }

        return valorTotal;
    }
}
