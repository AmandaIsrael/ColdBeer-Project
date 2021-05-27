package com.example.coldbeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class TelaInicio extends AppCompatActivity {
    private Intent telaCarrinho;
    private Intent telaProduto;
    private Intent telaLogin;
    private Intent perfilUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        perfilUser = new Intent(this, PerfilUsuario.class);
        telaCarrinho = new Intent(this, TelaCarrinho.class);
        telaProduto = new Intent(this, TelaListaProdutos.class);
        telaLogin = new Intent(this, TelaLogin.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void telaKits(View view){
        Intent kits = new Intent(this, TelaListaProdutos.class);
        startActivity(kits);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
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
            case R.id.perfilUsuario:
                startActivity(perfilUser);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}