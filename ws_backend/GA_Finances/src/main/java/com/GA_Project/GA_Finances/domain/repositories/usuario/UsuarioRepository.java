package com.GA_Project.GA_Finances.domain.repositories.usuario;

import com.GA_Project.GA_Finances.entity.usuarioEntity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findById(Long id);
}
