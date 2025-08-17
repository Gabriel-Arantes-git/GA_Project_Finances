package com.GA_Project.GA_Finances.domain.repositories.financeiro;

import com.GA_Project.GA_Finances.entity.financeiroEntity.TipoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TipoTransacaoRepository extends JpaRepository<TipoTransacao,Long> {

    Optional<TipoTransacao> findById(Long idkey);
}
