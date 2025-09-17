package com.leonelcujcuj.ahorcado.service;

import com.leonelcujcuj.ahorcado.model.Palabra;
import com.leonelcujcuj.ahorcado.repository.PalabraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalabraServiceImpl implements PalabraService{
    private final PalabraRepository palabraRepository;

    public PalabraServiceImpl(PalabraRepository palabraRepository) {
        this.palabraRepository = palabraRepository;
    }

    @Override
    public List<Palabra> getAllPalabras() {
        return palabraRepository.findAll();
    }

    @Override
    public Palabra getPalabraByid(Integer id) {
        return palabraRepository.findById(id).orElse(null);
    }

    @Override
    public Palabra savePalabra(Palabra palabra) {
        if (palabra == null){
            throw new IllegalArgumentException("La palabra no puede ser nula");
        }
        if (palabraRepository.findByNombre(palabra.getNombre()).isPresent()){
            throw new IllegalArgumentException("La palabra ya esta registrada");
        }
        return palabraRepository.save(palabra);
    }

    @Override
    public Palabra updatePalabra(Integer id, Palabra palabra) {
        if (palabraRepository.findByNombre(palabra.getNombre()).isPresent()){
            throw new IllegalArgumentException("La palabra ya esta registrada");
        }
        if (palabra == null){
            throw new IllegalArgumentException("La palabra no puede ser nula");
        }
        if (palabraRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("La palabra no existe");
        }
        Palabra existente = palabraRepository.findById(id).orElse(null);
        if (existente != null){
            existente.setNombre(palabra.getNombre());
            return palabraRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deletePalabra(Integer id) {
        palabraRepository.deleteById(id);
        if (palabraRepository.findById(id).isEmpty())
            throw new IllegalArgumentException("La palabra no existe");
    }
}
