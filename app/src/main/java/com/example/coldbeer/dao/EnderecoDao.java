package com.example.coldbeer.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EnderecoDao extends SQLiteOpenHelper {
    public static int VERSAO = 1;
    public static String DATABASE = "coldbeer";
    public static String TABELA = "endereco";

    public EnderecoDao(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String criarEndereco = "CREATE TABLE IF NOT EXISTS " + TABELA
                + " (cod_endereco INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " rua TEXT NOT NULL, " +
                " bairro TEXT NOT NULL, " +
                " numero INTEGER NOT NULL, " +
                " complemento TEXT, " +
                " frete REAL NOT NULL);";

        try {
            db.execSQL( criarEndereco );
            Log.i("INFO DB", "Sucesso ao criar a tabela endereço");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela endereço" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropEndereco = "DROP TABLE IF EXISTS " + TABELA + " ;" ;

        try {
            db.execSQL( dropEndereco );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App - tabela endereço" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App - tabela endereço" + e.getMessage() );
        }
    }
}
