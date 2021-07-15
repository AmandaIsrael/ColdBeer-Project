package com.example.coldbeer.activity;

import android.content.Context;
import android.content.Intent;

public class TelasMenu {

    private Intent TelaPrincipal = null;
    private Intent perfilUser = null;
    private Intent Kits = null;
    private Intent Sair = null;
    private Intent Carrinho = null;

    public TelasMenu() {}

    public Intent TelaPrincipal(Object object){
        if(TelaPrincipal == null) {
            TelaPrincipal = new Intent((Context) object, TelaInicio.class);
        }
        return TelaPrincipal;
    }

    public Intent perfUser(Object object){
        if(perfilUser == null) {
            perfilUser = new Intent((Context) object, TelaPerfilUsuario.class);
        }
        return perfilUser;
    }

    public Intent Kits(Object object){
        if(Kits == null) {
            Kits = new Intent((Context) object, TelaListaProdutos.class);
        }
        return Kits;
    }

    public Intent Out(Object object){
        if(Sair == null) {
            Sair = new Intent((Context) object, TelaLogin.class);
        }
        return Sair;
    }

    public Intent Cart(Object object){
        if(Carrinho == null) {
            Carrinho = new Intent((Context) object, TelaCarrinho.class);
        }
        return Carrinho;
    }
}
