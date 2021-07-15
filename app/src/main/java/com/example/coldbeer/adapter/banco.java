package com.example.coldbeer.adapter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coldbeer.R;
import com.example.coldbeer.help.DbHelper;

public class banco extends AppCompatActivity {
    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHelper db = new DbHelper(this);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();

        try{
            String consulta = "SELECT * FROM pessoa;";
            Cursor cursor = le.rawQuery(consulta,null);
            int indiceCodigo = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while(cursor != null) {
                String codigo = cursor.getString(indiceCodigo);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                Log.i("Resultado - id ", codigo + "; nome: " + nome +"; idade: " + idade+ ".");
                cursor.moveToNext();
            }
        } catch (Exception e) {
            Log.i("Info","Erro");
            e.printStackTrace();
        }
    }

}
