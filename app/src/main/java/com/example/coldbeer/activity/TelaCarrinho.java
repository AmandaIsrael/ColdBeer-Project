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
import android.widget.ActionMenuView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coldbeer.R;
import com.example.coldbeer.controller.TelasGateway;

public class TelaCarrinho extends AppCompatActivity {

    private TelasGateway Actual;
    private TextView item1;
    private TextView subtotal;
    private TextView valorUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_carrinho);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        TextView txtValorTotal = findViewById(R.id.txtTotal);
        txtValorTotal.setPaintFlags(txtValorTotal.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        item1 = findViewById(R.id.txtQuantidade);
        subtotal = findViewById(R.id.txtSubtotal);
        valorUnit = findViewById(R.id.txtPrecoUnit);

        ImageView aumentar = findViewById(R.id.btnAumentar);
        ImageView diminuir = findViewById(R.id.btnDiminuir);

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

        Actual = TelasGateway.getTelas();
    }

    private void calcularSubtotal(int quantidade){
        double valorUnitario = Double.parseDouble(valorUnit.getText().toString());
        double valorSub = valorUnitario*quantidade;
        subtotal.setText(String.valueOf(valorSub));
    }

    public void telaComprar(View view){
        Intent intent = Actual.FinalizarCompra(this);
        startActivity(intent);
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
                Intent Product = Actual.Kits(this);
                startActivity(Product);
                return true;
            case R.id.sair:
                Intent Login = Actual.Sair(this);
                startActivity(Login);
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