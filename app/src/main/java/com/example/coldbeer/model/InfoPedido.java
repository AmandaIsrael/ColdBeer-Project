package com.example.coldbeer.model;

import java.util.Date;

public class InfoPedido {
    int codInfoPedido;
    String formaPagamento, horarioEntrega;
    double troco, subtotal, total;
    Date data;
    Boolean finalizado;

    public InfoPedido(String formaPagamento, String horarioEntrega, double troco, double subtotal,
                      double total, Date data, Boolean finalizado) {
        this.formaPagamento = formaPagamento;
        this.horarioEntrega = horarioEntrega;
        this.troco = troco;
        this.subtotal = subtotal;
        this.total = total;
        this.data = data;
        this.finalizado = finalizado;
    }

    public int getCodInfoPedido() {
        return codInfoPedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getHorarioEntrega() {
        return horarioEntrega;
    }

    public void setHorarioEntrega(String horarioEntrega) {
        this.horarioEntrega = horarioEntrega;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }
}
