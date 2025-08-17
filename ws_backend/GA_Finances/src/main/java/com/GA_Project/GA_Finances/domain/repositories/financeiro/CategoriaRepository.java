package com.GA_Project.GA_Finances.domain.repositories.financeiro;

import com.GA_Project.GA_Finances.entity.financeiroEntity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    Optional<Categoria> findById(Long idkey);
}
