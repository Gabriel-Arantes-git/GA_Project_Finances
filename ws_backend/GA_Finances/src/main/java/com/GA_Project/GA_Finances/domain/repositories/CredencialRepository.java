package com.GA_Project.GA_Finances.domain.repositories;

import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial,Long> {

    Optional<Credencial> findByToken(String token);

    Optional<Credencial> findByEmail(String email);
}
