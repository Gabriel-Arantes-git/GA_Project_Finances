package com.GA_Project.GA_Finances.domain.service;

import com.GA_Project.GA_Finances.domain.repositories.financeiro.*;
import com.GA_Project.GA_Finances.domain.repositories.usuario.UsuarioRepository;
import com.GA_Project.GA_Finances.dto.financeiro.RequestNovaTransacaoDTO;
import com.GA_Project.GA_Finances.entity.financeiroEntity.*;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransacaoService {

    private final TransacaoRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final TipoTransacaoRepository tipoTransacaoRepository;
    private final CategoriaRepository categoriaRepository;
    private final NivelPrioridadeRepository nivelPrioridadeRepository;
    private final TipoCompraRepository tipoCompraRepository;

    public TransacaoService(TransacaoRepository repository,UsuarioRepository usuarioRepository,
                            TipoTransacaoRepository tipoTransacaoRepository,CategoriaRepository categoriaRepository,
                            NivelPrioridadeRepository nivelPrioridadeRepository,TipoCompraRepository tipoCompraRepository){
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.tipoTransacaoRepository = tipoTransacaoRepository;
        this.categoriaRepository = categoriaRepository;
        this.nivelPrioridadeRepository = nivelPrioridadeRepository;
        this.tipoCompraRepository = tipoCompraRepository;
    }

    public List<Transacao> buscarTransacaoPorUsuario(Long idkeyUsuario){
        usuarioRepository.findById(idkeyUsuario)
                .orElseThrow(()-> new RuntimeException("id de usuario inválido"));

        return  repository.findByUsuario(idkeyUsuario);
    }

    @Transactional
    public Transacao salvarTransacao(Long idkeyUsuario, RequestNovaTransacaoDTO dto){
        Usuario usuario = usuarioRepository.findById(idkeyUsuario)
                .orElseThrow(()-> new RuntimeException("id de usuario inválido"));

        TipoTransacao tipoTransacao = tipoTransacaoRepository.findById(dto.idTipoTransacao())
                .orElseThrow(()->new IllegalArgumentException("id de transacao invalido"));
        Categoria categoria = categoriaRepository.findById(dto.idCategoria())
                .orElseThrow(()->new IllegalArgumentException("id de categoria invalida"));
        NivelPrioridade nivelPrioridade = nivelPrioridadeRepository.findById(dto.idNivelPrioridade())
                .orElseThrow(()->new IllegalArgumentException("id de nivel de prioridade invalido"));
        TipoCompra tipoCompra = tipoCompraRepository.findById(dto.idTipoCompra())
                .orElseThrow(()->new IllegalArgumentException("id de tipo de compra invalido"));


        Transacao novaTransacao = new Transacao();
        novaTransacao.setNome(dto.nome());
        novaTransacao.setValor(dto.valor());
        novaTransacao.setData(dto.data());

        novaTransacao.setCategoria(categoria);
        novaTransacao.setTipoTransacao(tipoTransacao);
        novaTransacao.setTipoCompra(tipoCompra);
        novaTransacao.setNivelPrioridade(nivelPrioridade);

        Transacao transacaoSalva = repository.save(novaTransacao);

        usuario.addTransacao(transacaoSalva);
        usuarioRepository.save(usuario);

        return transacaoSalva;
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
