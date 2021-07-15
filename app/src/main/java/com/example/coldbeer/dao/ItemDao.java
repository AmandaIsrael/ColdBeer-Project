package com.example.coldbeer.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ItemDao extends SQLiteOpenHelper {
    private static final String TABELA_PRODUTO = "produto";
    public static int VERSAO = 1;
    public static String DATABASE = "coldbeer";
    public static String TABELA = "item";

    public ItemDao(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String criarItem = "CREATE TABLE IF NOT EXISTS " + TABELA
                + " (cod_item INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " preco_unit REAL NOT NULL, " +
                " quantidade INTEGER NOT NULL, " +
                " cod_produto INTEGER NOT NULL, "+
                " FOREIGN KEY (cod_produto) REFERENCES "+TABELA_PRODUTO+"(cod_produto));";

        try {
            db.execSQL( criarItem );
            Log.i("INFO DB", "Sucesso ao criar a tabela item");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela item" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropItem = "DROP TABLE IF EXISTS " + TABELA + " ;" ;

        try {
            db.execSQL( dropItem );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App - tabela item" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App - tabela item" + e.getMessage() );
        }
    }
}
