package com.example.coldbeer.model;

public class Cliente {

    int codCliente, idade;
    String email, nome, telefone;

    public Cliente(int idade, String email, String nome, String telefone) {
        this.idade = idade;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
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
}
