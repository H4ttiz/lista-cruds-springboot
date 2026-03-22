package com.unicesumar.lista_cruds_springboot.tarefas.controller;

import com.unicesumar.lista_cruds_springboot.tarefas.model.TarefaModel;
import com.unicesumar.lista_cruds_springboot.tarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TarefaModel> create(@RequestBody TarefaModel novaTarefa){
        TarefaModel tarefa = service.create(novaTarefa);
        return ResponseEntity.status(201).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> findAll(){
        List<TarefaModel> tarefas = service.findAll();
        return ResponseEntity.status(200).body(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            TarefaModel tarefa = service.findById(id);
            return ResponseEntity.status(200).body(tarefa);
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
