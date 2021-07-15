package com.example.coldbeer.help;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "coldbeer";
    public static String TABELA_CLIENTE = "cliente";
    public static String TABELA_ENDERECO = "endereco";
    public static String TABELA_PRODUTO = "produto";
    public static String TABELA_ITEM = "item";
    public static String TABELA_CARRINHO = "carrinho";
    public static String TABELA_PEDIDO = "pedido";
    public static String TABELA_INFO_PEDIDO = "info_pedido";

    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String criarEndereco = "CREATE TABLE IF NOT EXISTS " + TABELA_ENDERECO
                + " (cod_endereco INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " rua TEXT NOT NULL, " +
                " bairro TEXT NOT NULL, " +
                " numero INTEGER NOT NULL, " +
                " complemento TEXT, " +
                " frete REAL NOT NULL);";

        String criarCliente = "CREATE TABLE IF NOT EXISTS " + TABELA_CLIENTE
                + " (cod_cliente INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " email TEXT NOT NULL, " +
                " senha TEXT NOT NULL, " +
                " nome TEXT NOT NULL, " +
                " telefone TEXT NOT NULL, " +
                " idade INT(3)," +
                " cod_endereco INTEGER NOT NULL, "+
                " FOREIGN KEY (cod_endereco) REFERENCES "+TABELA_ENDERECO+"(cod_endereco));";

        String criarProduto = "CREATE TABLE IF NOT EXISTS " + TABELA_PRODUTO
                + " (cod_produto INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL, " +
                " preco_unitario REAL NOT NULL, " +
                " categoria BOOLEAN NOT NULL, " +
                " teor_alcoolico TEXT NOT NULL, " +
                " descricao TEXT NOT NULL);";

        String criarItem = "CREATE TABLE IF NOT EXISTS " + TABELA_ITEM
                + " (cod_item INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " preco_unit REAL NOT NULL, " +
                " quantidade INTEGER NOT NULL, " +
                " cod_produto INTEGER NOT NULL, "+
                " FOREIGN KEY (cod_produto) REFERENCES "+TABELA_PRODUTO+"(cod_produto));";

        String criarCarrinho = "CREATE TABLE IF NOT EXISTS " + TABELA_CARRINHO
                + " (cod_item INTEGER NOT NULL, " +
                " cod_cliente INTEGER NOT NULL, "+
                " PRIMARY KEY (cod_item, cod_cliente), "+
                " FOREIGN KEY (cod_item) REFERENCES "+TABELA_ITEM+"(cod_item), "+
                " FOREIGN KEY (cod_cliente) REFERENCES "+TABELA_CLIENTE+"(cod_cliente));";

        String criarInfoPedido = "CREATE TABLE IF NOT EXISTS " + TABELA_INFO_PEDIDO
                + " (cod_info_pedido INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " forma_pagamento TEXT NOT NULL, " +
                " troco REAL NOT NULL, " +
                " sub_total REAL NOT NULL, " +
                " total REAL NOT NULL, " +
                " data DATE NOT NULL, " +
                " horario_entrega TEXT NOT NULL, " +
                " finalizado BOOLEAN NOT NULL);";

        String criarPedido = "CREATE TABLE IF NOT EXISTS " + TABELA_PEDIDO
                + " (cod_item INTEGER NOT NULL, " +
                " cod_cliente INTEGER NOT NULL, "+
                " cod_info_pedido INTEGER NOT NULL, "+
                " PRIMARY KEY (cod_item, cod_cliente), "+
                " FOREIGN KEY (cod_item) REFERENCES "+TABELA_ITEM+"(cod_item), "+
                " FOREIGN KEY (cod_info_pedido) REFERENCES "+TABELA_INFO_PEDIDO+"(cod_info_pedido), "+
                " FOREIGN KEY (cod_cliente) REFERENCES "+TABELA_CLIENTE+"(cod_cliente));";

        try {
            db.execSQL( criarCliente );
            db.execSQL( criarEndereco );
            db.execSQL( criarProduto );
            db.execSQL( criarItem );
            db.execSQL( criarCarrinho );
            db.execSQL( criarInfoPedido );
            db.execSQL( criarPedido );
            Log.i("INFO DB", "Sucesso ao criar a tabela");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String dropCliente = "DROP TABLE IF EXISTS " + TABELA_CLIENTE + " ;" ;
        String dropEndereco = "DROP TABLE IF EXISTS " + TABELA_ENDERECO + " ;" ;
        String dropProduto = "DROP TABLE IF EXISTS " + TABELA_PRODUTO + " ;" ;
        String dropItem = "DROP TABLE IF EXISTS " + TABELA_ITEM + " ;" ;
        String dropCarrinho = "DROP TABLE IF EXISTS " + TABELA_CARRINHO + " ;" ;
        String dropInfoPedido = "DROP TABLE IF EXISTS " + TABELA_INFO_PEDIDO + " ;" ;
        String dropPedido = "DROP TABLE IF EXISTS " + TABELA_PEDIDO + " ;" ;

        try {
            db.execSQL( dropCliente );
            db.execSQL( dropEndereco );
            db.execSQL( dropProduto );
            db.execSQL( dropItem );
            db.execSQL( dropCarrinho );
            db.execSQL( dropInfoPedido );
            db.execSQL( dropPedido );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App" + e.getMessage() );
        }
    }
}
