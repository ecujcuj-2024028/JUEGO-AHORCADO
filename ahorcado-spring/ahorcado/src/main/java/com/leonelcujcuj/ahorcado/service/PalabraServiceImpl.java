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
        if (palabraRepository.findAll().isEmpty()){
            throw new IllegalArgumentException("No hay registros para mostrar");
        }
        return palabraRepository.findAll();
    }

    @Override
    public Palabra getPalabraByid(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        return palabraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La palabra con id " + id + " no existe"));
    }

    @Override
    public Palabra savePalabra(Palabra palabra) {
        if (palabra == null){
            throw new IllegalArgumentException("La palabra no puede ser nula");
        }
        if (palabraRepository.findByNombre(palabra.getNombre()).isPresent()){
            throw new IllegalArgumentException("La palabra ya esta registrada");
        }
        if (palabra.getNombre()== null || palabra.getNombre().isBlank()){
            throw new IllegalArgumentException("Es obligatorio el nombre");
        }
        if (palabra.getPista1() == null || palabra.getPista1().isBlank() ||
                palabra.getPista2() == null || palabra.getPista2().isBlank() ||
                palabra.getPista3() == null || palabra.getPista3().isBlank()) {
            throw new IllegalArgumentException("Las pistas son obligatorias");
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
        if (id == null || id <= 0){
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        if (palabra.getPista1().isEmpty() || palabra.getPista2().isEmpty() || palabra.getPista3().isEmpty()){
            throw new IllegalArgumentException("Las pistas son obligatorias");
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
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID debe ser válido y mayor a 0");
        }
        if (!palabraRepository.existsById(id)) {
            throw new IllegalArgumentException("La palabra con ID " + id + " no existe");
        }
        palabraRepository.deleteById(id);
    }
}
