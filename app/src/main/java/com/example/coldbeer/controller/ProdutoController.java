package com.example.coldbeer.controller;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.coldbeer.R;
import com.example.coldbeer.dao.ProdutoDao;
import com.example.coldbeer.model.Produto;
import java.util.List;

public class ProdutoController {
    public int[] imagens = {R.drawable.cerveja1,R.drawable.cerveja2,
            R.drawable.cerveja3, R.drawable.cerveja4, R.drawable.cerveja5};
    public int[] imagensFiltradas;
    RecyclerView.LayoutManager manager;
    AdapterListaProdutos adapter;
    ProdutoDao daoProduto;
    List<Produto> listaBancoProdutos;
    Produto produto;

    public List<Produto> listarProdutos(RecyclerView listaProduto, Context tela, String nome){
        manager = new GridLayoutManager(tela, 2);
        listaProduto.setHasFixedSize(true);
        listaProduto.setLayoutManager(manager);
        produto = new Produto();

        daoProduto = new ProdutoDao(tela);
        if(nome.isEmpty()){
            listaBancoProdutos = daoProduto.listarProdutos();
            adapter = new AdapterListaProdutos(listaBancoProdutos, imagens);
        }else{
            listaBancoProdutos = daoProduto.buscarProdutoPorNome(nome);

            for(int i=0; i< listaBancoProdutos.size(); i++){
                produto = listaBancoProdutos.get(i);
                imagensFiltradas[i] = imagens[produto.getCodProduto()-1];
            }
            adapter = new AdapterListaProdutos(listaBancoProdutos, imagensFiltradas);
        }
        listaProduto.setAdapter(adapter);

        return listaBancoProdutos;
    }
}