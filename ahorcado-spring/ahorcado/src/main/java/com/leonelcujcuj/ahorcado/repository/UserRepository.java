package com.leonelcujcuj.ahorcado.repository;

import com.leonelcujcuj.ahorcado.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNombreUsuario(String nombreUsuario);
    Optional<User> findByCorreo(String correo);
}
