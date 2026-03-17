package com.unicesumar.lista_cruds_springboot.pedido.controller;


import com.unicesumar.lista_cruds_springboot.pedido.model.PedidoModel;
import com.unicesumar.lista_cruds_springboot.pedido.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> listarTodos(){
        List<PedidoModel> pedidos = pedidoService.buscarTodos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> listarPorId(@PathVariable Long id){
        return pedidoService.buscarPorId(id)
                .map(pedido -> new ResponseEntity<>(pedido,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criar(@RequestBody PedidoModel novoPedido){
        PedidoModel criardo = pedidoService.criar(novoPedido);
        return new ResponseEntity<>(criardo,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
