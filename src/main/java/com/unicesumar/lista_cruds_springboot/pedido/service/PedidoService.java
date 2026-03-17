package com.unicesumar.lista_cruds_springboot.pedido.service;


import com.unicesumar.lista_cruds_springboot.pedido.model.PedidoModel;
import com.unicesumar.lista_cruds_springboot.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoModel criar(PedidoModel novoPedido){
        return pedidoRepository.save(novoPedido);
    }

    public List<PedidoModel> buscarTodos(){
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> buscarPorId(Long id){
        return pedidoRepository.findById(id);
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }
}
