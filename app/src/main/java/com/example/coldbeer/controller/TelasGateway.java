package com.example.coldbeer.controller;

import android.content.Context;
import android.content.Intent;

import com.example.coldbeer.activity.TelaCadastro;
import com.example.coldbeer.activity.TelaCarrinho;
import com.example.coldbeer.activity.TelaFinalizarCompra;
import com.example.coldbeer.activity.TelaInicio;
import com.example.coldbeer.activity.TelaItem;
import com.example.coldbeer.activity.TelaListaProdutos;
import com.example.coldbeer.activity.TelaLogin;
import com.example.coldbeer.activity.TelaMeusPedidos;
import com.example.coldbeer.activity.TelaPerfilUsuario;

public class TelasGateway {
    private static TelasGateway telasGateway;
    private Intent TelaPrincipal = null;
    private Intent perfilUser = null;
    private Intent Kits = null;
    private Intent Sair =null;
    private Intent Carrinho = null;
    private Intent item = null;
    private Intent finalizarCompra = null;
    private Intent cadastro = null;
    private Intent meusPedidos = null;

    private TelasGateway() {}

    public static TelasGateway getTelas(){
        if(telasGateway == null){
            telasGateway = new TelasGateway();
        }
        return telasGateway;
    }

    public Intent TelaPrincipal(Context context){
        if(TelaPrincipal == null) {
            TelaPrincipal = new Intent(context, TelaInicio.class);
        }
        return TelaPrincipal;
    }

    public Intent PerfUser(Context context){
        if(perfilUser == null) {
            perfilUser = new Intent(context, TelaPerfilUsuario.class);
        }
        return perfilUser;
    }

    public Intent Kits(Context context){
        if(Kits == null) {
            Kits = new Intent(context, TelaListaProdutos.class);
        }
        return Kits;
    }

    public Intent Sair(Context context){
        if(Sair == null) {
            Sair = new Intent(context, TelaLogin.class);
        }
        return Sair;
    }

    public Intent Carrinho(Context context){
        if(Carrinho == null) {
            Carrinho = new Intent(context, TelaCarrinho.class);
        }
        return Carrinho;
    }

    public Intent Item(Context context){
        if(item == null) {
            item = new Intent(context, TelaItem.class);
        }
        return item;
    }

    public Intent FinalizarCompra(Context context){
        if(finalizarCompra == null) {
            finalizarCompra = new Intent(context, TelaFinalizarCompra.class);
        }
        return finalizarCompra;
    }

    public Intent Cadastro(Context context){
        if(cadastro == null) {
            cadastro = new Intent(context, TelaCadastro.class);
        }
        return cadastro;
    }

    public Intent MeusPedidos(Context context){
        if(meusPedidos == null) {
            meusPedidos = new Intent(context, TelaMeusPedidos.class);
        }
        return meusPedidos;
    }
}