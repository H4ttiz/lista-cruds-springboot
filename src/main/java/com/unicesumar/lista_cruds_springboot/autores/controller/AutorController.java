package com.unicesumar.lista_cruds_springboot.autores.controller;

import com.unicesumar.lista_cruds_springboot.autores.model.AutorModel;
import com.unicesumar.lista_cruds_springboot.autores.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AutorModel> create(@RequestBody AutorModel autor) {
        AutorModel created = service.create(autor);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<AutorModel>> findAll() {
        List<AutorModel> autores = service.findAll();
        return ResponseEntity.status(200).body(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            AutorModel autor = service.findById(id);
            return ResponseEntity.status(200).body(autor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.status(204).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
