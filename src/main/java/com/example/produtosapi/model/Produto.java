package com.example.produtosapi.model;

import jakarta.persistence.Column;
import  jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/// POJO -> Plain Old Java Object / Planejado velho objeto Java
@Entity
@Table(name = "produto")  /// O Table Serve para a model saber qual o nome da tabela que está no banco e conseguir referenciar
                          /// Exemplo = Se no banco estiver escrito "Produtos" e na model "ProdutoP", colocar dentro do Column oque está no BANCO DE DADOS
public class Produto {

    @Id //Usado para saber qual é a chave primária do Banco de Dados
    @Column(name = "id") /// O Column Serve para a model saber qual o nome que está no banco e conseguir referenciar
    //Exemplo = Se no banco estiver escrito "Codigo" e na model "id", colocar dentro do Column oque está no BANCO DE DADOS
    private String id;

    private String nome;
    private String descricao;
    private Double preco;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
