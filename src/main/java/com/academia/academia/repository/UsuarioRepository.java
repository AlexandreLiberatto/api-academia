package com.academia.academia.repository;

import com.academia.academia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByLogin(String login);
}
