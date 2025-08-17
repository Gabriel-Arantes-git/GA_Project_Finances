package com.GA_Project.GA_Finances.domain.repositories.financeiro;

import com.GA_Project.GA_Finances.entity.financeiroEntity.NivelPrioridade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NivelPrioridadeRepository extends JpaRepository<NivelPrioridade,Long> {

    Optional<NivelPrioridade> findById(Long idkey);
}
