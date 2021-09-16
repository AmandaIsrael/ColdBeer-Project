package com.example.coldbeer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coldbeer.R;
import com.example.coldbeer.controller.ProdutoSelecionado;
import com.example.coldbeer.controller.TelasGateway;
import com.example.coldbeer.model.Produto;

public class TelaItem extends AppCompatActivity {

    private TelasGateway Actual;
    private Intent telaCarrinho;
    TextView txtPreco, txtTeorAlc, txtTitulo, txtDescricao;
    Produto produto;
    public static ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_item);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtTeorAlc = findViewById(R.id.txtTeorAlc);
        txtPreco = findViewById(R.id.txtPreco);
        txtDescricao = findViewById(R.id.txtDescricao);

        imagem = findViewById(R.id.imgProduto);

        telaCarrinho = new Intent(this, TelaCarrinho.class);

        produto = new Produto();
        produto = ProdutoSelecionado.getProdutoSelecionado();

        txtTitulo.setText(produto.getNome());
        txtTeorAlc.setText(produto.getTeorAlcoolico());
        txtPreco.setText(String.valueOf(produto.getPrecoUnitario()));
        txtDescricao.setText(produto.getDescricao());
        imagem.setImageResource(ProdutoSelecionado.getImagemProduto());

        Actual = TelasGateway.getTelas();
    }

    public void telaCarrinho(View view){
        telaCarrinho = Actual.Carrinho(this);
        startActivity(telaCarrinho);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.paginaPrincipal:
                Intent Inicial = Actual.TelaPrincipal(this);
                startActivity(Inicial);
                return true;
            case R.id.kits:
            case R.id.cervejas:
                Intent Products = Actual.Kits(this);
                startActivity(Products);
                return true;
            case R.id.sair:
                Intent Login = Actual.Sair(this);
                startActivity(Login);
                return true;
            case R.id.carrinho:
                Intent Cart = Actual.Carrinho(this);
                startActivity(Cart);
                return true;
            case R.id.meusPedidos:
                Intent MeusPedidos = Actual.MeusPedidos(this);
                startActivity(MeusPedidos);
                return true;
            case R.id.perfilUsuario:
                Intent perfUser = Actual.PerfUser(this);
                startActivity(perfUser);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}