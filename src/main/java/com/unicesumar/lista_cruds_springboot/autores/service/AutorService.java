package com.unicesumar.lista_cruds_springboot.autores.service;

import com.unicesumar.lista_cruds_springboot.autores.model.AutorModel;
import com.unicesumar.lista_cruds_springboot.autores.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public AutorModel create(AutorModel autor) {
        return repository.save(autor);
    }

    public List<AutorModel> findAll() {
        return repository.findAll();
    }

    public AutorModel findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }


    public void delete(Long id) {
        AutorModel autor = findById(id);
        repository.delete(autor);
    }
}
