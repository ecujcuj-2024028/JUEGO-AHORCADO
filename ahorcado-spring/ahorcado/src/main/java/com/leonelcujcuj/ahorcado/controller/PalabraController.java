package com.leonelcujcuj.ahorcado.controller;


import com.leonelcujcuj.ahorcado.model.Palabra;
import com.leonelcujcuj.ahorcado.service.PalabraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/palabra")
public class PalabraController {

    private final PalabraService palabraService;

    public PalabraController(PalabraService palabraService) {
        this.palabraService = palabraService;
    }

    @GetMapping
    public List<Palabra> getAllPalabras(){
        return palabraService.getAllPalabras();
    }

    @GetMapping("/{id}")
    public Palabra getPalabraById(@PathVariable Integer id){
        return palabraService.getPalabraByid(id);
    }

    @PostMapping
    public Palabra createPalabra(@RequestBody Palabra palabra){
        return palabraService.savePalabra(palabra);
    }

    @PutMapping("/{id}")
    public Palabra updatePalabra(@PathVariable Integer id, @RequestBody Palabra palabra){
        return palabraService.updatePalabra(id, palabra);
    }

    @DeleteMapping("/{id}")
    public void deletePalabra(@PathVariable Integer id){
        palabraService.deletePalabra(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleDuplicate(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
