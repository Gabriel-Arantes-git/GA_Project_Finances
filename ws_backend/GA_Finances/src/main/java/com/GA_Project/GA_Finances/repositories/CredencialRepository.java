package com.GA_Project.GA_Finances.repositories;

import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface CredencialRepository extends JpaRepository<Credencial,Long> {

    Optional<UserDetails> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
