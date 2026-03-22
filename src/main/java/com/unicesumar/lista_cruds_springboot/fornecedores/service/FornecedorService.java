package com.unicesumar.lista_cruds_springboot.fornecedores.service;

import com.unicesumar.lista_cruds_springboot.fornecedores.model.FornecedorModel;
import com.unicesumar.lista_cruds_springboot.fornecedores.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public FornecedorModel create(FornecedorModel novoFornecedor){
        return repository.save(novoFornecedor);
    }

    public List<FornecedorModel> findAll(){
        return repository.findAll();
    }

    public FornecedorModel findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public void delete(Long id){
        FornecedorModel dado = findById(id);
        repository.delete(dado);
    }
}
