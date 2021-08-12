package com.example.coldbeer.controller;

import android.content.Context;

import com.example.coldbeer.dao.ClienteDao;
import com.example.coldbeer.dao.EnderecoDao;
import com.example.coldbeer.model.Cliente;
import com.example.coldbeer.model.Endereco;
import java.util.List;
import java.util.Random;

public class TelaCadastroController {
    Cliente cliente;
    Endereco endereco;
    ClienteDao clienteDao = null;
    EnderecoDao enderecoDao = null;
    int codEndereco;

    public void TelaCadastroController() {
    }

    public void cadastrar(List<String> dadosPessoaisCliente, List<String> enderecoCliente, Context telaCadastro){
        cliente = new Cliente();
        endereco = new Endereco();
        cliente.setEmail(dadosPessoaisCliente.get(0));
        cliente.setSenha(dadosPessoaisCliente.get(1));
        cliente.setNome(dadosPessoaisCliente.get(2));
        cliente.setTelefone(dadosPessoaisCliente.get(3));
        cliente.setIdade(Integer.parseInt(dadosPessoaisCliente.get(4)));
        endereco.setRua(enderecoCliente.get(0));
        endereco.setBairro(enderecoCliente.get(1));
        endereco.setNumero(Integer.parseInt(enderecoCliente.get(2)));
        endereco.setComplemento(enderecoCliente.get(3));
        endereco.setFrete(random());

        enderecoDao = new EnderecoDao(telaCadastro);
        enderecoDao.inserirEndereco(endereco);
        codEndereco = enderecoDao.buscarCodEndereco(endereco);
        cliente.setCodEndereco(codEndereco);

        clienteDao = new ClienteDao(telaCadastro);
        clienteDao.inserirCliente(cliente);

        clienteDao.listarClientes();
        enderecoDao.listarEnderecos();
    }

    public int random(){
        int number = new Random().nextInt(10);
        return number;
    }
}
