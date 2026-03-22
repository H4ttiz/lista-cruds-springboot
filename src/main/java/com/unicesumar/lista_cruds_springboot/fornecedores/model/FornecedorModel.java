package com.unicesumar.lista_cruds_springboot.fornecedores.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_fornecedor")
public class FornecedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    private String cnpf;

    @Column(name = "contato_fornecedor")
    private String contato;

    public FornecedorModel() {
    }

    public FornecedorModel(String nomeFantasia, String cnpf, String contato) {
        this.nomeFantasia = nomeFantasia;
        this.cnpf = cnpf;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpf() {
        return cnpf;
    }

    public void setCnpf(String cnpf) {
        this.cnpf = cnpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
