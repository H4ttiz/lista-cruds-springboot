package com.unicesumar.lista_cruds_springboot.cliente.controller;

import com.unicesumar.lista_cruds_springboot.cliente.model.ClienteModel;
import com.unicesumar.lista_cruds_springboot.cliente.servive.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteModel> create(@RequestBody ClienteModel novoCliente){
        ClienteModel cliente = service.create(novoCliente);
        return ResponseEntity.status(201).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        List<ClienteModel> clientes = service.findAll();
        return ResponseEntity.status(200).body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            ClienteModel cliente = service.findById(id);
            return ResponseEntity.status(200).body(cliente);
        } catch (RuntimeException e) {
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
