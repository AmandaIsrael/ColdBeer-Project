package com.example.coldbeer.help;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbGateway {
    private static DbGateway gw;
    private SQLiteDatabase le;
    private SQLiteDatabase escreve;


    private DbGateway(Context ctx){
        DbHelper helper = new DbHelper(ctx);
        escreve = helper.getWritableDatabase();
        le = helper.getReadableDatabase();
    }

    public static DbGateway getInstance(Context ctx){
        if(gw == null)
            gw = new DbGateway(ctx);
        return gw;
    }

    public SQLiteDatabase getDatabase(Boolean escreve){
        if(escreve){
            return this.escreve;
        }else {
            return this.le;
        }
    }
}
