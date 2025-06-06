package com.aguacatech.repository;

import com.aguacatech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreo(String correo);
}
