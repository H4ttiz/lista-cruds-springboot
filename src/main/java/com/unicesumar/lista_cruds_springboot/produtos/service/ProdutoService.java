package com.unicesumar.lista_cruds_springboot.produtos.service;

import com.unicesumar.lista_cruds_springboot.produtos.model.ProdutoModel;
import com.unicesumar.lista_cruds_springboot.produtos.repository.ProdutoRepository;
import com.unicesumar.lista_cruds_springboot.tarefas.model.TarefaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoModel create(ProdutoModel novoProduto){
        return repository.save(novoProduto);
    }

    public List<ProdutoModel> findAll(){
        return repository.findAll();
    }

    public ProdutoModel findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrada"));
    }

    public void deletar(Long id){
        ProdutoModel dado = findById(id);
        repository.delete(dado);
    }
}
