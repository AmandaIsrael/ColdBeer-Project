package com.example.coldbeer.controller;

import android.content.Context;

import com.example.coldbeer.dao.ClienteDao;
import com.example.coldbeer.dao.EnderecoDao;
import com.example.coldbeer.model.Cliente;
import com.example.coldbeer.model.Endereco;
import java.util.List;
import java.util.Random;

public class ClienteController {
    Cliente cliente;
    Endereco endereco;
    ClienteDao clienteDao = null;
    EnderecoDao enderecoDao = null;
    int codEndereco, retornoInsercao;

    public void TelaCadastroController() {
    }

    public int cadastrar(List<String> dadosPessoaisCliente, List<String> enderecoCliente, Context telaCadastro){
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
        codEndereco = enderecoDao.buscarCodEndereco(endereco);
        if(codEndereco == 0) {
            enderecoDao.inserirEndereco(endereco);
            codEndereco = enderecoDao.buscarCodEndereco(endereco);
        }
        cliente.setCodEndereco(codEndereco);

        clienteDao = new ClienteDao(telaCadastro);
        retornoInsercao = clienteDao.inserirCliente(cliente);

        clienteDao.listarClientes();
        enderecoDao.listarEnderecos();

        return retornoInsercao;
    }

    public int atualizar(List<String> dadosPessoaisCliente, List<String> enderecoCliente, Context telaCadastro){
        cliente = new Cliente();
        endereco = new Endereco();
        cliente.setEmail(dadosPessoaisCliente.get(0));
        cliente.setSenha(dadosPessoaisCliente.get(1));
        cliente.setNome(dadosPessoaisCliente.get(2));
        cliente.setTelefone(dadosPessoaisCliente.get(3));
        cliente.setIdade(Integer.parseInt(dadosPessoaisCliente.get(4)));
        cliente.setCodCliente(Integer.parseInt(dadosPessoaisCliente.get(5)));
        cliente.setCodEndereco(Integer.parseInt(enderecoCliente.get(4)));

        endereco.setRua(enderecoCliente.get(0));
        endereco.setBairro(enderecoCliente.get(1));
        endereco.setNumero(Integer.parseInt(enderecoCliente.get(2)));
        endereco.setComplemento(enderecoCliente.get(3));
        endereco.setCodEndereco(Integer.parseInt(enderecoCliente.get(4)));
        endereco.setFrete(random());

        enderecoDao = new EnderecoDao(telaCadastro);
        codEndereco = enderecoDao.buscarCodEndereco(endereco);
        if(codEndereco == 0) {
            enderecoDao.inserirEndereco(endereco);
            codEndereco = enderecoDao.buscarCodEndereco(endereco);
        }
        cliente.setCodEndereco(codEndereco);

        clienteDao = new ClienteDao(telaCadastro);
        retornoInsercao = clienteDao.inserirCliente(cliente);

        clienteDao.listarClientes();
        enderecoDao.listarEnderecos();

        return retornoInsercao;
    }



    public int random(){
        int number = new Random().nextInt(10);
        return number;
    }
}
