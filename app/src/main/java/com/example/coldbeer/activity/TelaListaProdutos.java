package com.example.coldbeer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.coldbeer.R;
import com.example.coldbeer.controller.AdapterListaProdutos;
import com.example.coldbeer.controller.TelasGateway;
import com.example.coldbeer.dao.ProdutoDao;
import com.example.coldbeer.model.Produto;

import java.util.List;

public class TelaListaProdutos extends AppCompatActivity {

    private TelasGateway Actual;
    private Intent telaItem;
    RecyclerView listaProduto;
    RecyclerView.LayoutManager manager;
    AdapterListaProdutos adapter;
    ProdutoDao daoProduto;
    List<Produto> listaBancoProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_produtos);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        int[] imagens = {R.drawable.cerveja1,R.drawable.cerveja2,
                R.drawable.cerveja3, R.drawable.cerveja4, R.drawable.cerveja5};

        listaProduto = findViewById(R.id.recyclerViewProdutos);
        //RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager = new GridLayoutManager(this, 2);
        listaProduto.setHasFixedSize(true);
        listaProduto.setLayoutManager(manager);

        daoProduto = new ProdutoDao(getApplicationContext());
        listaBancoProdutos = daoProduto.listarProdutos();
        adapter = new AdapterListaProdutos(listaBancoProdutos, imagens);
        listaProduto.setAdapter(adapter);

        Actual = TelasGateway.getTelas();
    }

    public void item(View view){
        telaItem =  Actual.Item(this);
        startActivity(telaItem);
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
                Intent UserProfile = Actual.PerfUser(this);
                startActivity(UserProfile);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}