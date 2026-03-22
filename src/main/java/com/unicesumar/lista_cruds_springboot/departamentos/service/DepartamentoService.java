package com.unicesumar.lista_cruds_springboot.departamentos.service;

import com.unicesumar.lista_cruds_springboot.departamentos.model.DepartamentoModel;
import com.unicesumar.lista_cruds_springboot.departamentos.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository repository;

    public DepartamentoService(DepartamentoRepository repository) {
        this.repository = repository;
    }

    public DepartamentoModel create(DepartamentoModel novoDepartamento){
        return repository.save(novoDepartamento);
    }

    public List<DepartamentoModel> findAll(){
        return repository.findAll();
    }

    public DepartamentoModel finadById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
    }

    public void deletar(Long id){
        DepartamentoModel dado = finadById(id);
        repository.delete(dado);
    }
}
