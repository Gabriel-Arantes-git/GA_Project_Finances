package com.GA_Project.GA_Finances.domain.repositories.financeiro;

import com.GA_Project.GA_Finances.entity.financeiroEntity.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ParcelaRepository extends JpaRepository<Parcela,Long> {

    @Query(value = """
            SELECT
            	p.*
            FROM financeiro.parcela p
            WHERE
            	p.idkey_transacao = :id_transacao""",nativeQuery = true)
    List<Parcela> findParcelasByTransacao(@Param("id_transacao") Long idkey_transacao);

    Optional<Parcela> findById(Long idkey);
}
