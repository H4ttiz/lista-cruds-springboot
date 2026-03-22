package com.unicesumar.lista_cruds_springboot.categorias.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_categoria")
    private String nome;

    @Column(name = "descricao_categoria")
    private String descricao;

    public CategoriaModel() {
    }

    public CategoriaModel(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
