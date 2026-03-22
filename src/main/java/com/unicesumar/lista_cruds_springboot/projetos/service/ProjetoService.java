package com.unicesumar.lista_cruds_springboot.projetos.service;

import com.unicesumar.lista_cruds_springboot.projetos.model.ProjetoModel;
import com.unicesumar.lista_cruds_springboot.projetos.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository repository;

    public ProjetoService(ProjetoRepository repository) {
        this.repository = repository;
    }

    public ProjetoModel create(ProjetoModel novoProjeto){
        return repository.save(novoProjeto);
    }

    public List<ProjetoModel> findAll(){
        return repository.findAll();
    }

    public ProjetoModel findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    public void delete(Long id){
        ProjetoModel dado = findById(id);
        repository.delete(dado);
    }
}
