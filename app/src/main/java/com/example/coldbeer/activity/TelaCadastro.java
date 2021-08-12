package com.example.coldbeer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.coldbeer.R;
import com.example.coldbeer.controller.TelaCadastroController;
import com.example.coldbeer.dao.ClienteDao;
import com.example.coldbeer.dao.EnderecoDao;
import com.example.coldbeer.model.Cliente;
import com.example.coldbeer.model.Endereco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TelaCadastro extends AppCompatActivity {
    EditText email;
    EditText senha;
    EditText nome;
    EditText telefone;
    EditText idade;
    EditText rua;
    EditText numero;
    EditText bairro;
    EditText complemento;
    Button cadastrar;
    TelaCadastroController controllerCadastro;
    Cliente cliente;
    Endereco enderecoModel;
    EnderecoDao enderecoDao;
    ClienteDao clienteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        email = (EditText)findViewById(R.id.txtEmail);
        senha = (EditText)findViewById(R.id.txtSenha);
        nome = (EditText)findViewById(R.id.txtNome);
        telefone = (EditText)findViewById(R.id.txtTelefone);
        idade = (EditText)findViewById(R.id.txtIdade);
        rua = (EditText)findViewById(R.id.txtRua);
        numero = (EditText)findViewById(R.id.txtNumero);
        bairro = (EditText)findViewById(R.id.txtBairro);
        complemento = (EditText)findViewById(R.id.txtComplemento);
        cadastrar = (Button)findViewById(R.id.btnAtualizar);
        //controllerCadastro = new TelaCadastroController();
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> dadosCliente = new ArrayList<>();
                dadosCliente.add(email.getText().toString());
                dadosCliente.add(senha.getText().toString());
                dadosCliente.add(nome.getText().toString());
                dadosCliente.add(telefone.getText().toString());
                dadosCliente.add(idade.getText().toString());

                List<String> endereco = new ArrayList<>();
                endereco.add(rua.getText().toString());
                endereco.add(bairro.getText().toString());
                endereco.add(numero.getText().toString());
                endereco.add(complemento.getText().toString());

                controllerCadastro = new TelaCadastroController();
                controllerCadastro.cadastrar(dadosCliente, endereco, getApplicationContext());
            }
        });
    }

    public void telaLogin(View view){
        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);
    }

    public int random(){
        int number = new Random().nextInt(10);
        return number;
    }

   /* public void cadastrar(View view){
        List<String> dadosCliente = new ArrayList<>();
        dadosCliente.add(email.getText().toString());
        dadosCliente.add(senha.getText().toString());
        dadosCliente.add(nome.getText().toString());
        dadosCliente.add(telefone.getText().toString());
        dadosCliente.add(idade.getText().toString());

        List<String> endereco = new ArrayList<>();
        endereco.add(rua.getText().toString());
        endereco.add(bairro.getText().toString());
        endereco.add(numero.getText().toString());
        endereco.add(complemento.getText().toString());

        controllerCadastro.cadastrar(dadosCliente, endereco);
    }*/
}