package com.unicesumar.lista_cruds_springboot.fornecedores.repository;

import com.unicesumar.lista_cruds_springboot.fornecedores.model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<FornecedorModel,Long> {
}
