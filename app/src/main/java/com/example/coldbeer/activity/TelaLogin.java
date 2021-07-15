package com.example.coldbeer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.coldbeer.R;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void telaCadastro(View view){
        Intent intent = new Intent(this, TelaCadastro.class);
        startActivity(intent);
    }

    public void telaInicio(View view){
        Intent intent = new Intent(this, TelaInicio.class);
        startActivity(intent);
    }
}