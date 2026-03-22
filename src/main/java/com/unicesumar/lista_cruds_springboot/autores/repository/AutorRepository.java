package com.unicesumar.lista_cruds_springboot.autores.repository;

import com.unicesumar.lista_cruds_springboot.autores.model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {
}
