package com.GA_Project.GA_Finances.domain.repositories.usuario;

import com.GA_Project.GA_Finances.entity.usuarioEntity.Credencial;
import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial,Long> {

    Optional<Credencial> findById(Long idkey);
    Optional<Credencial> findByEmail(String email);

    @Query(value = "SELECT * FROM usuario.usuario WHERE idkey_credencial = :credencialId",nativeQuery = true)
    Optional<Usuario>findUserByIdkeyCredencial(@Param("credencialId") Long credencialId);
}
