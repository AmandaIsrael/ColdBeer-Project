package com.example.coldbeer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.coldbeer.R;
import com.example.coldbeer.controller.TelaLoginController;
import com.example.coldbeer.controller.TelasGateway;
import com.example.coldbeer.controller.UsuarioAtualController;
import com.example.coldbeer.model.Cliente;

public class TelaLogin extends AppCompatActivity {
    TextView txtErro;
    Button entrar;
    String email, senha;
    EditText txtEmail, txtSenha;
    TelaLoginController controllerLogin;
    Cliente cliente;
    TelasGateway Actual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtErro = (TextView) findViewById(R.id.txtErroLogin);
        entrar = (Button) findViewById(R.id.btnEntrar);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        Actual = TelasGateway.getTelas();

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = txtEmail.getText().toString();
                senha = txtSenha.getText().toString();

                controllerLogin = new TelaLoginController();
                cliente = controllerLogin.login(email, senha, getApplicationContext());

                if(cliente == null){
                    txtErro.setText("Email ou senha incorretos!");
                }else {
                    UsuarioAtualController.setUserAtual(cliente, getApplicationContext());
                    telaInicio(v);
                }
            }
        });
    }

    public void telaCadastro(View view){
        Intent intent = Actual.Cadastro(this);
        startActivity(intent);
    }

    public void telaInicio(View view){
        Intent intent = Actual.TelaPrincipal(this);
        startActivity(intent);
    }
}