package com.unicesumar.lista_cruds_springboot.departamentos.controller;

import com.unicesumar.lista_cruds_springboot.departamentos.model.DepartamentoModel;
import com.unicesumar.lista_cruds_springboot.departamentos.service.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> create (@RequestBody DepartamentoModel novoDepartamento){
        DepartamentoModel departamento = service.create(novoDepartamento);
        return ResponseEntity.status(201).body(departamento);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> departamentos = service.findAll();
        return ResponseEntity.status(200).body(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            DepartamentoModel departamento = service.finadById(id);
            return ResponseEntity.status(200).body(departamento);
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
