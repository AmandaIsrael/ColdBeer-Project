package com.example.coldbeer.model;

public class Cliente {
    int codCliente, idade, codEndereco;
    String email, nome, telefone, senha;

    public Cliente(int idade, String email, String nome, String telefone, String senha, int cod_endereco) {
        this.idade = idade;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.codEndereco = cod_endereco;
    }

    public Cliente(){}

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(int cod_endereco) {
        this.codEndereco = cod_endereco;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
