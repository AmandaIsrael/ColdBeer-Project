package com.example.coldbeer.activity;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import com.example.coldbeer.dao.ProdutoDao;
import com.example.coldbeer.model.Produto;

public class popularProdutos {

    public static void cadastrarProduto(Context tela){
        //nome, String teorAlcoolico, String descricao, Double precoUnitario, Boolean categoria
       /* Produto produto = new Produto("Blondine Biru Ginjo Beer",
                "7,0%",
                "Desenvolvida para homenagear a cultura japonesa, com ingredientes relacionados ao país: malte de cevada, arroz, lúpulo japonês Sorachi Ace e levedura de saquê. A levedura garante uma característica singular, aromas únicos frutados e leves, que harmonizam com os de malte e lúpulo.",
                10.32, false);
        Produto produto2 = new Produto("Blondine Blond Ale",
                "5,7%",
                "Dispõe de espuma cremosa, aroma condimentado de especiarias como moscada e cravo, além das frutas amarelas. Seu sabor é levemente adocicado e picante, com predominância do malte e sutil de levedura belga.",
                16.72, false);
        Produto produto3 = new Produto("Blondine Circus IPA",
                "6,5%",
                "Apresenta corpo mais alto e amargor mais equilibrado com base de malte, coloração âmbar, além das inebiantes notas florais e terrosas no aroma.",
                14.34, false);*/
        ProdutoDao daoProduto = new ProdutoDao(tela);
        Produto produto = new Produto();
        produto = daoProduto.buscarProduto(2);
        produto.setNome("Blondine Bad Moose");
        daoProduto.atualizarProduto(produto);

        /*daoProduto.inserirProduto(produto);
        daoProduto.inserirProduto(produto2);
        daoProduto.inserirProduto(produto3);*/

        daoProduto.listarProdutos();
    }
}
