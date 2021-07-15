package com.example.coldbeer.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class InfoPedidoDao extends SQLiteOpenHelper {
    public static int VERSAO = 1;
    public static String DATABASE = "coldbeer";
    public static String TABELA = "infoPedido";

    public InfoPedidoDao(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String criarInfoPedido = "CREATE TABLE IF NOT EXISTS " + TABELA
                + " (cod_info_pedido INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " forma_pagamento TEXT NOT NULL, " +
                " troco REAL NOT NULL, " +
                " sub_total REAL NOT NULL, " +
                " total REAL NOT NULL, " +
                " data DATE NOT NULL, " +
                " horario_entrega TEXT NOT NULL, " +
                " finalizado BOOLEAN NOT NULL);";
        try {
            db.execSQL( criarInfoPedido );
            Log.i("INFO DB", "Sucesso ao criar a tabela infoPedido");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela infoPedido" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropInfoPedido = "DROP TABLE IF EXISTS " + TABELA + " ;" ;

        try {
            db.execSQL( dropInfoPedido );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App - tabela infoPedido" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App- tabela infoPedido" + e.getMessage() );
        }
    }
}
