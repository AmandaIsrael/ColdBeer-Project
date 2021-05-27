package com.example.coldbeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TelaFinalizarCompra extends AppCompatActivity {
    private Intent perfilUser;
    private Intent telaCarrinho;
    private Intent telaInicio;
    private Intent telaProduto;
    private Intent telaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_finalizar_compra);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        TextView txtTotal = findViewById(R.id.txtTotal);
        txtTotal.setPaintFlags(txtTotal.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        perfilUser = new Intent(this, PerfilUsuario.class);
        telaCarrinho = new Intent(this, TelaCarrinho.class);
        telaInicio = new Intent(this, TelaInicio.class);
        telaProduto = new Intent(this, TelaListaProdutos.class);
        telaLogin = new Intent(this, TelaLogin.class);
    }

    public void telaAlterarEndereco(View view){
        startActivity(perfilUser);
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
            case R.id.perfilUsuario:
                startActivity(perfilUser);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}