package com.example.coldbeer.controller;

import android.content.Context;

import com.example.coldbeer.dao.EnderecoDao;
import com.example.coldbeer.model.Cliente;
import com.example.coldbeer.model.Endereco;

public class UsuarioAtualController {
    private static Cliente usuario;
    private static Endereco endereco;
    private static EnderecoDao daoEndereco;

    public static Cliente getUserAtual(){
        return usuario;
    }

    public static Endereco getEnderecoAtual(){ return endereco;}

    public static void setUserAtual(Cliente cliente, Context context){
        usuario = cliente;
        daoEndereco = new EnderecoDao(context);
        endereco = daoEndereco.buscarEndereco(cliente.getCodEndereco());
    }
}
