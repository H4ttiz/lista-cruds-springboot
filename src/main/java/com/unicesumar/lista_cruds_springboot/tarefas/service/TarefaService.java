package com.unicesumar.lista_cruds_springboot.tarefas.service;

import com.unicesumar.lista_cruds_springboot.tarefas.model.TarefaModel;
import com.unicesumar.lista_cruds_springboot.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public TarefaModel create(TarefaModel novaTarefa){
        return repository.save(novaTarefa);
    }

    public List<TarefaModel> findAll(){
        return repository.findAll();
    }

    public TarefaModel findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada"));
    }

    public void deletar(Long id){
        TarefaModel dado = findById(id);
        repository.delete(dado);
    }
}
