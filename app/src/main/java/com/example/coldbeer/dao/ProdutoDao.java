package com.example.coldbeer.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ProdutoDao extends SQLiteOpenHelper {
    public static int VERSAO = 1;
    public static String DATABASE = "coldbeer";
    public static String TABELA = "produto";

    public ProdutoDao(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String criarProduto = "CREATE TABLE IF NOT EXISTS " + TABELA
                + " (cod_produto INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL, " +
                " preco_unitario REAL NOT NULL, " +
                " categoria BOOLEAN NOT NULL, " +
                " teor_alcoolico TEXT NOT NULL, " +
                " descricao TEXT NOT NULL);";

        try {
            db.execSQL( criarProduto );
            Log.i("INFO DB", "Sucesso ao criar a tabela produto");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela produto" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropProduto = "DROP TABLE IF EXISTS " + TABELA + " ;" ;

        try {
            db.execSQL( dropProduto );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App - tabela produto" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App - tabela produto" + e.getMessage() );
        }
    }
}
