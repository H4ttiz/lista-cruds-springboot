package com.unicesumar.lista_cruds_springboot.categorias.controller;


import com.unicesumar.lista_cruds_springboot.autores.model.AutorModel;
import com.unicesumar.lista_cruds_springboot.categorias.model.CategoriaModel;
import com.unicesumar.lista_cruds_springboot.categorias.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> create(@RequestBody CategoriaModel categoria){
        CategoriaModel novaCategoria = service.create(categoria);
        return ResponseEntity.status(201).body(novaCategoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAll(){
        List<CategoriaModel> categorias = service.findAll();
        return ResponseEntity.status(200).body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            CategoriaModel categoria = service.findById(id);
            return ResponseEntity.status(200).body(categoria);
        }catch (RuntimeException e) {
            return ResponseEntity.status(404)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(204).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
