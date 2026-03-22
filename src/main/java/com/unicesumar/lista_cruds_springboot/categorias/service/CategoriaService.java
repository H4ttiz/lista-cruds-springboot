package com.unicesumar.lista_cruds_springboot.categorias.service;

import com.unicesumar.lista_cruds_springboot.categorias.model.CategoriaModel;
import com.unicesumar.lista_cruds_springboot.categorias.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public CategoriaModel create(CategoriaModel categoria){
        return repository.save(categoria);
    }

    public List<CategoriaModel> findAll(){
        return repository.findAll();
    }

    public CategoriaModel findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrado"));
    }

    public void delete(Long id){
        CategoriaModel dado = findById(id);
        repository.delete(dado);
    }
}
