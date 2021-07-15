package com.example.coldbeer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.coldbeer.R;

public class TelaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
    }

    public void telaLogin(View view){
        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);
    }
}