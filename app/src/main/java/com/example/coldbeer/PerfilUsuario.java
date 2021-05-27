package com.example.coldbeer;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;


public class PerfilUsuario extends AppCompatActivity {
    private Intent telaCarrinho;
    private Intent telaInicio;
    private Intent telaProduto;
    private Intent telaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        telaCarrinho = new Intent(this, TelaCarrinho.class);
        telaInicio = new Intent(this, TelaInicio.class);
        telaProduto = new Intent(this, TelaListaProdutos.class);
        telaLogin = new Intent(this, TelaLogin.class);
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
            case R.id.kits:
            case R.id.cervejas:
                startActivity(telaProduto);
                return true;
            case R.id.sair:
                startActivity(telaLogin);
                return true;
            case R.id.carrinho:
                startActivity(telaCarrinho);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

