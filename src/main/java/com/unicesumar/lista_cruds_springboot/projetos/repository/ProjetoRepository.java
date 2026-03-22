package com.unicesumar.lista_cruds_springboot.projetos.repository;

import com.unicesumar.lista_cruds_springboot.projetos.model.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<ProjetoModel,Long> {
}
