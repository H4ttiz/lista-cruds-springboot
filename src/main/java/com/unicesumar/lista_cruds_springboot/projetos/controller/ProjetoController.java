package com.unicesumar.lista_cruds_springboot.projetos.controller;

import com.unicesumar.lista_cruds_springboot.projetos.model.ProjetoModel;
import com.unicesumar.lista_cruds_springboot.projetos.service.ProjetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    private final ProjetoService service;

    public ProjetoController(ProjetoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProjetoModel> create(@RequestBody ProjetoModel novoProjeto){
        ProjetoModel projeto = service.create(novoProjeto);
        return ResponseEntity.status(201).body(projeto);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> findAll(){
        List<ProjetoModel> projetos = service.findAll();
        return ResponseEntity.status(200).body(projetos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            ProjetoModel projeto = service.findById(id);
            return ResponseEntity.status(200).body(projeto);
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
