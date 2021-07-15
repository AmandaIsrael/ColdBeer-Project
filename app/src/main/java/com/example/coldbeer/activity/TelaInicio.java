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

public class TelaInicio extends AppCompatActivity {

    private TelasMenu Actual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        Actual = new TelasMenu();
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.kits:
            case R.id.cervejas:
                Intent Product = Actual.Kits(this);
                startActivity(Product);
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