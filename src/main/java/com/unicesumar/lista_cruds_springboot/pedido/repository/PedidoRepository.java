package com.unicesumar.lista_cruds_springboot.pedido.repository;

import com.unicesumar.lista_cruds_springboot.pedido.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
