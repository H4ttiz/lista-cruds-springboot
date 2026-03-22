package com.unicesumar.lista_cruds_springboot.cliente.serive;

import com.unicesumar.lista_cruds_springboot.cliente.model.ClienteModel;
import com.unicesumar.lista_cruds_springboot.cliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteModel create(ClienteModel cliente){
        return repository.save(cliente);
    }

    public List<ClienteModel> findAll(){
        return repository.findAll();
    }

    public ClienteModel findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void delete(Long id){
        ClienteModel dado = findById(id);
        repository.delete(dado);
    }
}
