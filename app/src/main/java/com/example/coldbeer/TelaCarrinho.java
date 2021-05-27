package com.example.coldbeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Console;

public class TelaCarrinho extends AppCompatActivity {
    private Intent telaPerfilUsuario;
    private Intent telaInicio;
    private Intent telaProduto;
    private Intent telaLogin;
    private TextView item1;
    private TextView subtotal;
    private TextView valorUnit;
    private ImageView aumentar;
    private ImageView diminuir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_carrinho);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        TextView txtValorTotal = findViewById(R.id.txtTotal);
        txtValorTotal.setPaintFlags(txtValorTotal.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        telaPerfilUsuario = new Intent(this, PerfilUsuario.class);
        telaInicio = new Intent(this, TelaInicio.class);
        telaProduto = new Intent(this, TelaListaProdutos.class);
        telaLogin = new Intent(this, TelaLogin.class);
        item1 = findViewById(R.id.txtQuantidade);
        subtotal = findViewById(R.id.txtSubtotal);
        valorUnit = findViewById(R.id.txtPrecoUnit);
        aumentar = findViewById(R.id.btnAumentar);
        diminuir = findViewById(R.id.btnDiminuir);

        aumentar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int valorAtual = Integer.parseInt(item1.getText().toString());
                valorAtual = valorAtual + 1;
                item1.setText(String.valueOf(valorAtual));
                calcularSubtotal(valorAtual);
                }
        });

        diminuir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int valorAtual = Integer.parseInt(item1.getText().toString());
                valorAtual = valorAtual - 1;
                item1.setText(String.valueOf(valorAtual));
                calcularSubtotal(valorAtual);
            }
        });
    }

    private void calcularSubtotal(int quantidade){
        double valorUnitario = Double.parseDouble(valorUnit.getText().toString());
        double valorSub = valorUnitario*quantidade;
        subtotal.setText(String.valueOf(valorSub));
    }

    public void telaComprar(View view){
        Intent intent = new Intent(this, TelaFinalizarCompra.class);
        startActivity(intent);
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
            case R.id.perfilUsuario:
                startActivity(telaPerfilUsuario);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}