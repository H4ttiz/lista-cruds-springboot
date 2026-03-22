package com.unicesumar.lista_cruds_springboot.tarefas.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_tarefa")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "tarefa_concluida")
    private boolean concluida;

    public TarefaModel() {
    }

    public TarefaModel(String descricao, LocalDate dataVencimento, boolean concluida) {
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.concluida = concluida;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
