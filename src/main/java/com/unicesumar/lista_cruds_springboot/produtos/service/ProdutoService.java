package com.unicesumar.lista_cruds_springboot.produtos.service;

import com.unicesumar.lista_cruds_springboot.produtos.model.ProdutoModel;
import com.unicesumar.lista_cruds_springboot.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoModel criar(ProdutoModel novoProduto){
        return produtoRepository.save(novoProduto);
    }

    public List<ProdutoModel> listarTodos(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> listarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
