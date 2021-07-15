package com.example.coldbeer.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ClienteDao extends SQLiteOpenHelper {
    private static final String TABELA_ENDERECO = "endereco";
    public static int VERSAO = 1;
    public static String DATABASE = "coldbeer";
    public static String TABELA = "cliente";

    public ClienteDao(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String criarCliente = "CREATE TABLE IF NOT EXISTS " + TABELA
                + " (cod_cliente INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " email TEXT NOT NULL, " +
                " senha TEXT NOT NULL, " +
                " nome TEXT NOT NULL, " +
                " telefone TEXT NOT NULL, " +
                " idade INT(3)," +
                " cod_endereco INTEGER NOT NULL, "+
                " FOREIGN KEY (cod_endereco) REFERENCES "+TABELA_ENDERECO+"(cod_endereco));";

        try {
            db.execSQL(criarCliente);
            Log.i("INFO DB", "Sucesso ao criar a tabela cliente");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela cliente" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropCliente = "DROP TABLE IF EXISTS " + TABELA + " ;" ;

        try {
            db.execSQL( dropCliente );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App - tabela cliente" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App - tabela cliente" + e.getMessage() );
        }
    }
}
