package com.example.coldbeer.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;

import com.example.coldbeer.R;
import com.example.coldbeer.controller.ClienteController;
import com.example.coldbeer.controller.TelasGateway;
import com.example.coldbeer.controller.UsuarioAtualController;
import com.example.coldbeer.model.Cliente;
import com.example.coldbeer.model.Endereco;

import java.util.ArrayList;
import java.util.List;


public class TelaPerfilUsuario extends AppCompatActivity {

    private TelasGateway Actual;
    EditText email;
    EditText senha;
    EditText nome;
    EditText telefone;
    EditText idade;
    EditText rua;
    EditText numero;
    EditText bairro;
    EditText complemento;
    Button atualizar;
    Cliente userAtual;
    Endereco enderecoAtual;
    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        userAtual = UsuarioAtualController.getUserAtual();
        enderecoAtual = UsuarioAtualController.getEnderecoAtual();
        Actual = TelasGateway.getTelas();
        email = (EditText)findViewById(R.id.txtEmail);
        senha = (EditText)findViewById(R.id.txtSenha);
        nome = (EditText)findViewById(R.id.txtNome);
        telefone = (EditText)findViewById(R.id.txtTelefone);
        idade = (EditText)findViewById(R.id.txtIdade);
        rua = (EditText)findViewById(R.id.txtRua);
        numero = (EditText)findViewById(R.id.txtNumero);
        bairro = (EditText)findViewById(R.id.txtBairro);
        complemento = (EditText)findViewById(R.id.txtComplemento);
        atualizar = (Button)findViewById(R.id.btnAtualizar);

        email.setText(userAtual.getEmail());
        senha.setText(userAtual.getSenha());
        nome.setText(userAtual.getNome());
        telefone.setText(userAtual.getTelefone());
        idade.setText(String.valueOf(userAtual.getIdade()));
        rua.setText(enderecoAtual.getRua());
        numero.setText(String.valueOf(enderecoAtual.getNumero()));
        bairro.setText(enderecoAtual.getBairro());
        complemento.setText(enderecoAtual.getComplemento());

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> dadosCliente = new ArrayList<>();
                dadosCliente.add(email.getText().toString());
                dadosCliente.add(senha.getText().toString());
                dadosCliente.add(nome.getText().toString());
                dadosCliente.add(telefone.getText().toString());
                dadosCliente.add(idade.getText().toString());
                dadosCliente.add(String.valueOf(userAtual.getCodCliente()));

                List<String> endereco = new ArrayList<>();
                endereco.add(rua.getText().toString());
                endereco.add(bairro.getText().toString());
                endereco.add(numero.getText().toString());
                endereco.add(complemento.getText().toString());
                endereco.add(String.valueOf(enderecoAtual.getCodEndereco()));

                clienteController = new ClienteController();
                clienteController.atualizar(dadosCliente, endereco, getApplicationContext());
            }
        });
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
            case R.id.carrinho:
                Intent Cart = Actual.Carrinho(this);
                startActivity(Cart);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

