package com.unicesumar.lista_cruds_springboot.produtos.repository;

import com.unicesumar.lista_cruds_springboot.produtos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
