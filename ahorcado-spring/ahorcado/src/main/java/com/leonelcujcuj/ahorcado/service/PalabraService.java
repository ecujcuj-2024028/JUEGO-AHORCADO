package com.leonelcujcuj.ahorcado.service;

import com.leonelcujcuj.ahorcado.model.Palabra;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalabraService {
    List<Palabra> getAllPalabras();
    Palabra getPalabraByid(Integer id);
    Palabra savePalabra(Palabra palabra);
    Palabra updatePalabra(Integer id, Palabra palabra);
    void deletePalabra(Integer id);
}
