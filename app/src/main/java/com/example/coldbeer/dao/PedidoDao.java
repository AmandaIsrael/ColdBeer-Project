package com.example.coldbeer.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PedidoDao extends SQLiteOpenHelper {
    public static int VERSAO = 1;
    public static String DATABASE = "coldbeer";
    public static String TABELA = "pedido";
    public static String TABELA_ITEM = "item";
    public static String TABELA_INFO_PEDIDO = "infoPedido";
    public static String TABELA_CLIENTE = "cliente";

    public PedidoDao(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String criarPedido = "CREATE TABLE IF NOT EXISTS " + TABELA
                + " (cod_item INTEGER NOT NULL, " +
                " cod_cliente INTEGER NOT NULL, "+
                " cod_info_pedido INTEGER NOT NULL, "+
                " PRIMARY KEY (cod_item, cod_cliente), "+
                " FOREIGN KEY (cod_item) REFERENCES "+TABELA_ITEM+"(cod_item), "+
                " FOREIGN KEY (cod_info_pedido) REFERENCES "+TABELA_INFO_PEDIDO+"(cod_info_pedido), "+
                " FOREIGN KEY (cod_cliente) REFERENCES "+TABELA_CLIENTE+"(cod_cliente));";

        try {
            db.execSQL( criarPedido );
            Log.i("INFO DB", "Sucesso ao criar a tabela pedido");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela pedido" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropPedido = "DROP TABLE IF EXISTS " + TABELA + " ;" ;

        try {
            db.execSQL( dropPedido );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App - tabela pedido" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App - tabela pedido" + e.getMessage() );
        }
    }
}
