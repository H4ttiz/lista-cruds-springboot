package com.unicesumar.lista_cruds_springboot.livro.controller;

import com.unicesumar.lista_cruds_springboot.livro.model.LivroModel;
import com.unicesumar.lista_cruds_springboot.livro.service.LivroService;
import com.unicesumar.lista_cruds_springboot.pedido.model.PedidoModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<LivroModel> create(@RequestBody LivroModel novaLivro){
        LivroModel livro = service.create(novaLivro);
        return ResponseEntity.status(201).body(livro);
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll(){
        List<LivroModel> livros = service.findAll();
        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            LivroModel livro = service.findById(id);
            return ResponseEntity.status(200).body(livro);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404)
                    .body(Map.of("error",e.getMessage()));
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
