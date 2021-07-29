package com.example.coldbeer.model;

public class Endereco {
    String rua, bairro, complemento;
    int codEndereco, numero;
    double frete;

    public Endereco(int codEndereco, String rua, String bairro, String complemento, int numero, double frete) {
        this.codEndereco = codEndereco;
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numero = numero;
        this.frete = frete;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCodEndereco() {
        return codEndereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }
}
