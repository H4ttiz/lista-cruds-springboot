package com.unicesumar.lista_cruds_springboot.departamentos.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_departamento")
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_departamento")
    private String nome;

    @Column(name = "localizacao_departamento")
    private String localizacao;

    public DepartamentoModel() {
    }

    public DepartamentoModel(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
