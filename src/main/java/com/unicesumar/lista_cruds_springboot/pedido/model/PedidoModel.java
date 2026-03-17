package com.unicesumar.lista_cruds_springboot.pedido.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pedido")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_pedido")
    private LocalDateTime date;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    private String status;

    public PedidoModel(LocalDateTime date, BigDecimal valorTotal, String status) {
        this.date = date;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public PedidoModel() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
