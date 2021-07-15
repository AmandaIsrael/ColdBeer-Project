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

import com.example.coldbeer.R;

public class TelaListaProdutos extends AppCompatActivity {

    private TelasMenu Actual;
    private Intent telaItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_produtos);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        Actual = new TelasMenu();
    }

    public void item(View view){
        telaItem =  new Intent(this, TelaItem.class);
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
                Intent Login = Actual.Out(this);
                startActivity(Login);
                return true;
            case R.id.carrinho:
                Intent Cart = Actual.Cart(this);
                startActivity(Cart);
                return true;
            case R.id.perfilUsuario:
                Intent UserProfile = Actual.perfUser(this);
                startActivity(UserProfile);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}