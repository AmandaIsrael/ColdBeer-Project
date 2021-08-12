package com.example.coldbeer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.coldbeer.R;
import com.example.coldbeer.controller.TelasGateway;

public class TelaMeusPedidos extends AppCompatActivity {
    private TelasGateway Actual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_meus_pedidos);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        Actual = TelasGateway.getTelas();
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
                Intent Inicio = Actual.TelaPrincipal(this);
                startActivity(Inicio);
                return true;
            case R.id.kits:
            case R.id.cervejas:
                Intent Product = Actual.Kits(this);
                startActivity(Product);
                return true;
            case R.id.sair:
                Intent Login = Actual.Sair(this);
                startActivity(Login);
                return true;
            case R.id.carrinho:
                Intent Cart = Actual.Carrinho(this);
                startActivity(Cart);
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