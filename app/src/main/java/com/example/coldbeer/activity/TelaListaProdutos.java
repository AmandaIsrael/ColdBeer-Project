package com.example.coldbeer.activity;

import androidx.annotation.NonNull;
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
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coldbeer.R;
import com.example.coldbeer.controller.AdapterListaProdutos;
import com.example.coldbeer.controller.ProdutoController;
import com.example.coldbeer.controller.ProdutoSelecionado;
import com.example.coldbeer.controller.RecyclerItemClickListener;
import com.example.coldbeer.controller.TelasGateway;
import com.example.coldbeer.dao.ProdutoDao;
import com.example.coldbeer.model.Produto;

import java.util.List;

public class TelaListaProdutos extends AppCompatActivity {

    private TelasGateway Actual;
    private Intent telaItem;
    RecyclerView listaProduto;
    ProdutoController produtoController;
    List<Produto> listaBancoProduto;
    TextView txtBusca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_produtos);

        txtBusca = findViewById(R.id.txtBusca);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        int[] imagens = {R.drawable.cerveja1, R.drawable.cerveja2,
                R.drawable.cerveja3, R.drawable.cerveja4, R.drawable.cerveja5};

        listaProduto = findViewById(R.id.recyclerViewProdutos);

        produtoController = new ProdutoController();
        listaBancoProduto = produtoController.listarProdutos(listaProduto, getApplicationContext(), txtBusca.getText().toString());

        Actual = TelasGateway.getTelas();

        listaProduto.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(), listaProduto, new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        Produto produto = listaBancoProduto.get(position);
                        ProdutoSelecionado.setProdutoAtual(produto);
                        item(view);
                        /*Toast.makeText(getApplicationContext(), "Click Curto: " +
                                produto.getCodProduto(), Toast.LENGTH_SHORT).show();*/
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }));
    }

        public void item (View view){
            telaItem = Actual.Item(this);
            startActivity(telaItem);
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }

        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onOptionsItemSelected (MenuItem item){

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

        public void buscarProduto(View view){
            listaBancoProduto = produtoController.listarProdutos(listaProduto, getApplicationContext(), txtBusca.getText().toString());
        }
}