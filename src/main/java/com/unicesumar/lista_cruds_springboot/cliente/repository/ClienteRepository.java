package com.unicesumar.lista_cruds_springboot.cliente.repository;

import com.unicesumar.lista_cruds_springboot.cliente.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
