package com.unicesumar.lista_cruds_springboot.tarefas.repository;

import com.unicesumar.lista_cruds_springboot.tarefas.model.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel,Long> {
}
