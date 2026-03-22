package com.unicesumar.lista_cruds_springboot.produtos.controller;


import com.unicesumar.lista_cruds_springboot.produtos.model.ProdutoModel;
import com.unicesumar.lista_cruds_springboot.produtos.service.ProdutoService;
import com.unicesumar.lista_cruds_springboot.tarefas.model.TarefaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> create(@RequestBody ProdutoModel novaProduto){
        ProdutoModel produto = service.create(novaProduto);
        return ResponseEntity.status(201).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> produtos = service.findAll();
        return ResponseEntity.status(200).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            ProdutoModel produto = service.findById(id);
            return ResponseEntity.status(200).body(produto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404)
                    .body(Map.of("error",e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            service.deletar(id);
            return ResponseEntity.status(204).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
