package com.GA_Project.GA_Finances.domain.repositories.financeiro;

import com.GA_Project.GA_Finances.entity.financeiroEntity.TipoCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoCompraRepository extends JpaRepository<TipoCompra,Long> {

    Optional<TipoCompra> findById(Long idkey);
}
