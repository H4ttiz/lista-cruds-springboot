package com.unicesumar.lista_cruds_springboot.categorias.repository;

import com.unicesumar.lista_cruds_springboot.categorias.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
