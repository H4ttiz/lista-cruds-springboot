package com.unicesumar.lista_cruds_springboot.departamentos.repository;

import com.unicesumar.lista_cruds_springboot.departamentos.model.DepartamentosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentosModel,Long> {
}
