package com.example.coldbeer.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
    Button deletar;
    Cliente userAtual;
    Endereco enderecoAtual;
    ClienteController clienteController;
    Cliente retornoAtualizar;
    String titulo, mensagem;
    boolean retornoDeletar;

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
        deletar = (Button)findViewById(R.id.btnDeletar);

        email.setText(userAtual.getEmail());
        senha.setText(userAtual.getSenha());
        nome.setText(userAtual.getNome());
        telefone.setText(userAtual.getTelefone());
        idade.setText(String.valueOf(userAtual.getIdade()));
        rua.setText(enderecoAtual.getRua());
        numero.setText(String.valueOf(enderecoAtual.getNumero()));
        bairro.setText(enderecoAtual.getBairro());
        complemento.setText(enderecoAtual.getComplemento());


        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                titulo = "Aten????o";
                mensagem = "Voc?? realmente deseja excluir seu perfil no Coldbeer?";

                AlertDialog.Builder popupDeletar = new AlertDialog.Builder(TelaPerfilUsuario.this);
                popupDeletar.setTitle(titulo);
                popupDeletar.setMessage(mensagem);
                popupDeletar.setCancelable(false);
                popupDeletar.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clienteController = new ClienteController();
                        retornoDeletar = clienteController.deletar(userAtual.getCodCliente(), getApplicationContext());

                        if(retornoDeletar){
                            titulo = "Sucesso";
                            mensagem = "Conta exclu??da!";
                        }else{
                            titulo = "Erro";
                            mensagem = "Erro ao atualizar perfil!";
                        }

                        AlertDialog.Builder popupDeletarOk = new AlertDialog.Builder(TelaPerfilUsuario.this);
                        popupDeletarOk.setTitle(titulo);
                        popupDeletarOk.setMessage(mensagem);
                        popupDeletarOk.setCancelable(false);
                        popupDeletarOk.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(retornoDeletar){
                                    telaLogin(v);
                                }
                            }
                        });
                        popupDeletarOk.create().show();
                    }
                });
                popupDeletar.setNegativeButton("N??o", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                popupDeletar.create().show();
            }
        });

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
                retornoAtualizar = clienteController.atualizar(dadosCliente, endereco, getApplicationContext());

                if(retornoAtualizar != null){
                    titulo = "Sucesso";
                    mensagem = "Usu??rio atualizado!";
                    UsuarioAtualController.setUserAtual(retornoAtualizar, getApplicationContext());
                }else{
                    titulo = "Erro";
                    mensagem = "Erro ao atualizar perfil!";
                }

                AlertDialog.Builder popupAtualizar = new AlertDialog.Builder(TelaPerfilUsuario.this);
                popupAtualizar.setTitle(titulo);
                popupAtualizar.setMessage(mensagem);
                popupAtualizar.setCancelable(false);
                popupAtualizar.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                popupAtualizar.create().show();
            }
        });
    }

    public void telaLogin(View view){
        Intent intent = Actual.Sair(this);
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
            case R.id.carrinho:
                Intent Cart = Actual.Carrinho(this);
                startActivity(Cart);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

