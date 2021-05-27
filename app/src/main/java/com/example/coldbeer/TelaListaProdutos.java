package com.example.coldbeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class TelaListaProdutos extends AppCompatActivity {
    private Intent perfilUser;
    private Intent telaCarrinho;
    private Intent telaInicio;
    private Intent telaLogin;
    private Intent telaItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_produtos);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        perfilUser = new Intent(this, PerfilUsuario.class);
        telaCarrinho = new Intent(this, TelaCarrinho.class);
        telaInicio = new Intent(this, TelaInicio.class);
        telaLogin = new Intent(this, TelaLogin.class);
        telaItem =  new Intent(this, TelaItem.class);
    }

    public void item(View view){
        startActivity(telaItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.paginaPrincipal:
                startActivity(telaInicio);
                return true;
            case R.id.sair:
                startActivity(telaLogin);
                return true;
            case R.id.carrinho:
                startActivity(telaCarrinho);
                return true;
            case R.id.perfilUsuario:
                startActivity(perfilUser);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}