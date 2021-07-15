package com.example.coldbeer.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CarrinhoDao extends SQLiteOpenHelper {
    private static final String TABELA_ITEM = "item";
    private static final String TABELA_CLIENTE = "cliente";
    public static int VERSAO = 1;
    public static String DATABASE = "coldbeer";
    public static String TABELA = "carrinho";

    public CarrinhoDao(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String criarCarrinho = "CREATE TABLE IF NOT EXISTS " + TABELA
                + " (cod_item INTEGER NOT NULL, " +
                " cod_cliente INTEGER NOT NULL, "+
                " PRIMARY KEY (cod_item, cod_cliente), "+
                " FOREIGN KEY (cod_item) REFERENCES "+TABELA_ITEM+"(cod_item), "+
                " FOREIGN KEY (cod_cliente) REFERENCES "+TABELA_CLIENTE+"(cod_cliente));";

        try {
            db.execSQL( criarCarrinho );
            Log.i("INFO DB", "Sucesso ao criar a tabela carrinho");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela carrinho" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropCarrinho = "DROP TABLE IF EXISTS " + TABELA + " ;" ;

        try {
            db.execSQL( dropCarrinho );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App - tabela carrinho" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App - tabela carrinho" + e.getMessage() );
        }
    }
}
