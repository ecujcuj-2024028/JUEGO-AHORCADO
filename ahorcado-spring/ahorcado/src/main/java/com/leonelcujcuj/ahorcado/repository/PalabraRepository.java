package com.leonelcujcuj.ahorcado.repository;

import com.leonelcujcuj.ahorcado.model.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PalabraRepository extends JpaRepository<Palabra, Integer> {
    Optional<Palabra> findByNombre(String nombre);
}
