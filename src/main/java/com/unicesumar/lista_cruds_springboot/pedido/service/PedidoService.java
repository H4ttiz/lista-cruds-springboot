package com.unicesumar.lista_cruds_springboot.pedido.service;


import com.unicesumar.lista_cruds_springboot.pedido.model.PedidoModel;
import com.unicesumar.lista_cruds_springboot.pedido.repository.PedidoRepository;
import com.unicesumar.lista_cruds_springboot.produtos.model.ProdutoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public PedidoModel create(PedidoModel novoPedido){
        return repository.save(novoPedido);
    }

    public List<PedidoModel> findAll(){
        return repository.findAll();
    }

    public PedidoModel findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido não encontrada"));
    }

    public void delete(Long id){
        PedidoModel dado = findById(id);
        repository.deleteById(id);
    }
}
