package com.example.coldbeer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.coldbeer.R;
import com.example.coldbeer.controller.TelasGateway;

public class TelaFinalizarCompra extends AppCompatActivity {

    private TelasGateway Actual;
    private Intent perfilUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_finalizar_compra);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        TextView txtTotal = findViewById(R.id.txtTotal);
        txtTotal.setPaintFlags(txtTotal.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Actual = TelasGateway.getTelas();
    }

    public void telaAlterarEndereco(View view){
        perfilUser = Actual.PerfUser(this);
        startActivity(perfilUser);
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
            case R.id.meusPedidos:
                Intent MeusPedidos = Actual.MeusPedidos(this);
                startActivity(MeusPedidos);
                return true;
            case R.id.carrinho:
                Intent Cart = Actual.Carrinho(this);
                startActivity(Cart);
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