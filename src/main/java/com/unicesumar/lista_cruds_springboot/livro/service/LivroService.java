package com.unicesumar.lista_cruds_springboot.livro.service;


import com.unicesumar.lista_cruds_springboot.livro.model.LivroModel;
import com.unicesumar.lista_cruds_springboot.livro.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public LivroModel criar(LivroModel novoLivro){
        return livroRepository.save(novoLivro);
    }

    public List<LivroModel> listarTodos(){
        return livroRepository.findAll();
    }

    public Optional<LivroModel> listarPorId(Long id){
        return livroRepository.findById(id);
    }

    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }
}
