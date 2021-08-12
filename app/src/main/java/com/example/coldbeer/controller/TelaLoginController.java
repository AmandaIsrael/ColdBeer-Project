package com.example.coldbeer.controller;


import android.content.Context;

import com.example.coldbeer.dao.ClienteDao;
import com.example.coldbeer.model.Cliente;

public class TelaLoginController {
    Cliente cliente;
    ClienteDao clienteDao = null;

    public void TelaLoginController(){}

    public Cliente login (String email, String senha, Context telaLogin){
        clienteDao = new ClienteDao(telaLogin);
        cliente = clienteDao.clienteLogin(email, senha);
        return cliente;
    }
}
