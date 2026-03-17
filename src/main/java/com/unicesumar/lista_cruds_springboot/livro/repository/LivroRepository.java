package com.unicesumar.lista_cruds_springboot.livro.repository;

import com.unicesumar.lista_cruds_springboot.livro.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel,Long> {
}
