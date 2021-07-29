package com.example.coldbeer.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.coldbeer.help.DbGateway;
import com.example.coldbeer.help.DbHelper;
import com.example.coldbeer.model.Endereco;

public class EnderecoDao {
    private SQLiteDatabase escreve;
    private SQLiteDatabase le;
    private DbHelper db;
    private DbGateway gatewayDb;

    public EnderecoDao(Context context) {
        gatewayDb = DbGateway.getInstance(context);
        escreve = gatewayDb.getDatabase(true);
        le = gatewayDb.getDatabase(false);
    }

    public String inserirEndereco(Endereco endereco) {
        ContentValues valores;
        long resultado;

        valores = new ContentValues();
        valores.put("rua", endereco.getRua());
        valores.put("bairro", endereco.getBairro());
        valores.put("numero", endereco.getNumero());
        valores.put("complemento", endereco.getComplemento());
        valores.put("frete", endereco.getFrete());

        resultado = escreve.insert(db.TABELA_ENDERECO, null, valores);
        //db.close();

        if (resultado == -1) {
            return ("Erro ao inserir na tabela endereço!");
        } else {
            return ("Registro inserido com sucesso na tabela endereço!");
        }
    }

    public void listarEnderecos() {
        try {
            String consulta = "SELECT * FROM endereco";
            Cursor cursor = le.rawQuery(consulta, null);

            int indiceCodigo = cursor.getColumnIndex("cod_endereco");
            int indiceRua = cursor.getColumnIndex("rua");
            int indiceBairro = cursor.getColumnIndex("bairro");
            int indiceNumero = cursor.getColumnIndex("numero");
            int indiceComplemento = cursor.getColumnIndex("complemento");
            int indiceFrete = cursor.getColumnIndex("frete");

            cursor.moveToFirst();

            while (cursor != null) {
                int codigo = cursor.getInt(indiceCodigo);
                String rua = cursor.getString(indiceRua);
                String bairro = cursor.getString(indiceBairro);
                int numero = cursor.getInt(indiceNumero);
                String complemento = cursor.getString(indiceComplemento);
                double frete = cursor.getDouble(indiceFrete);

                Log.i("id: ", codigo + " rua: " + rua + " bairro: " + bairro + " numero: " + numero +
                        " complemento: " + complemento + " frete: " + frete);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
    }

    public Endereco buscarEndereco(int cod_endereco) {
        Endereco endereco = null;
        try {
            String consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco + ";";
            Cursor cursor = le.rawQuery(consulta, null);

            int indiceRua = cursor.getColumnIndex("rua");
            int indiceBairro = cursor.getColumnIndex("bairro");
            int indiceNumero = cursor.getColumnIndex("numero");
            int indiceComplemento = cursor.getColumnIndex("complemento");
            int indiceFrete = cursor.getColumnIndex("frete");

            String rua = cursor.getString(indiceRua);
            String bairro = cursor.getString(indiceBairro);
            int numero = cursor.getInt(indiceNumero);
            String complemento = cursor.getString(indiceComplemento);
            double frete = cursor.getDouble(indiceFrete);

            endereco = new Endereco(cod_endereco, rua, bairro, complemento, numero, frete);

            Log.i("id: ", cod_endereco + " rua: " + rua + " bairro: " + bairro + " numero: " + numero +
                    " complemento: " + complemento + " frete: " + frete);
        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
        return endereco;
    }
}
