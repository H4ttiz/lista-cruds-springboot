package com.unicesumar.lista_cruds_springboot.fornecedores.controller;

import com.unicesumar.lista_cruds_springboot.fornecedores.model.FornecedorModel;
import com.unicesumar.lista_cruds_springboot.fornecedores.service.FornecedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    public final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FornecedorModel> create(@RequestBody FornecedorModel novoFornecedor){
        FornecedorModel fornecedor = service.create(novoFornecedor);
        return ResponseEntity.status(201).body(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll(){
        List<FornecedorModel> fornecedores = service.findAll();
        return ResponseEntity.status(200).body(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            FornecedorModel fornecedor = service.findById(id);
            return ResponseEntity.status(200).body(fornecedor);
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
