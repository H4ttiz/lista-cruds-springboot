package com.unicesumar.lista_cruds_springboot.pedido.controller;


import com.unicesumar.lista_cruds_springboot.pedido.model.PedidoModel;
import com.unicesumar.lista_cruds_springboot.pedido.service.PedidoService;
import com.unicesumar.lista_cruds_springboot.produtos.model.ProdutoModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PedidoModel> create(@RequestBody PedidoModel novaPedido){
        PedidoModel pedido = service.create(novaPedido);
        return ResponseEntity.status(201).body(pedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> findAll(){
        List<PedidoModel> pedidos = service.findAll();
        return ResponseEntity.status(200).body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            PedidoModel pedido = service.findById(id);
            return ResponseEntity.status(200).body(pedido);
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
