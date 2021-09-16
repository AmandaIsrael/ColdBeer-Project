package com.example.coldbeer.controller;

import android.widget.ImageView;

import com.example.coldbeer.model.Produto;

public class ProdutoSelecionado {
    public static Produto produto;
    public static ProdutoController controllerProduto;
    public static int index;

    public static Produto getProdutoSelecionado(){
        return produto;
    }

    public static void setProdutoAtual(Produto produtoAtual){
        produto = produtoAtual;
    }

    public static int getImagemProduto(){
        controllerProduto = new ProdutoController();
        index = controllerProduto.imagens[produto.getCodProduto()-1];
        return index;
    }
}
