package com.GA_Project.GA_Finances.domain.repositories;

import com.GA_Project.GA_Finances.entity.financeiroEntity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Long> {

    @Query(value =
            """
                    SELECT\s
                    t.*\s
                    FROM tuplas.tpl_transacao_usuario tu\s
                    INNER JOIN financeiro.transacao t
                    ON t.idkey = tu.idkey_transacao
                    WHERE
                    tu.idkey_usuario = :id_usuario""",nativeQuery = true)
    List<Transacao> findByUsuario(@Param("id_usuario") Long idkeyUsuario);

    @Query(value =
            """
                    SELECT\s
                    t.*\s
                    FROM tuplas.tpl_transacao_usuario tu\s
                    INNER JOIN financeiro.transacao t
                    ON t.idkey = tu.idkey_transacao
                    WHERE
                    tu.idkey_usuario = :id_usuario and t.idkey_tipo_transacao = 1""",nativeQuery = true)
    List<Transacao> findGanhosByUsuario(@Param("id_usuario") Long idkeyUsuario);

    @Query(value =
            """
                    SELECT\s
                    t.*\s
                    FROM tuplas.tpl_transacao_usuario tu\s
                    INNER JOIN financeiro.transacao t
                    ON t.idkey = tu.idkey_transacao
                    WHERE
                    tu.idkey_usuario = :id_usuario and t.idkey_tipo_transacao = 2""",nativeQuery = true)
    List<Transacao> findDespesasByUsuario(@Param("id_usuario") Long idkeyUsuario);
}
