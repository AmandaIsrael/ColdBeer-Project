package com.example.coldbeer.model;

public class Produto {
    int codProduto;
    String nome, teorAlcoolico, descricao;
    Double precoUnitario;
    Boolean categoria;
    //categoria -> 0=cerveja, 1=kit

    public Produto(String nome, String teorAlcoolico, String descricao, Double precoUnitario, Boolean categoria) {
        this.nome = nome;
        this.teorAlcoolico = teorAlcoolico;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.categoria = categoria;
    }

    public Produto(){}

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(String teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Boolean getCategoria() {
        return categoria;
    }

    public void setCategoria(Boolean categoria) {
        this.categoria = categoria;
    }
}
