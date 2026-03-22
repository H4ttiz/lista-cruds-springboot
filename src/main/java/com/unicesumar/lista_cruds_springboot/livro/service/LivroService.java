package com.unicesumar.lista_cruds_springboot.livro.service;


import com.unicesumar.lista_cruds_springboot.livro.model.LivroModel;
import com.unicesumar.lista_cruds_springboot.livro.repository.LivroRepository;
import com.unicesumar.lista_cruds_springboot.pedido.model.PedidoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public LivroModel create(LivroModel novoLivro){
        return repository.save(novoLivro);
    }

    public List<LivroModel> findAll(){
        return repository.findAll();
    }

    public LivroModel findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Livro não encontrada"));
    }

    public void delete(Long id){
        LivroModel dado = findById(id);
        repository.deleteById(id);
    }
}
