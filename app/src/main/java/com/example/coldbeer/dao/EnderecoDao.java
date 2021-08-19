package com.example.coldbeer.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.coldbeer.help.DbGateway;
import com.example.coldbeer.help.DbHelper;
import com.example.coldbeer.model.Endereco;

import java.util.ArrayList;
import java.util.List;

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

    public int inserirEndereco(Endereco endereco) {
        ContentValues valores;
        int codigo;

        valores = new ContentValues();
        valores.put("rua", endereco.getRua());
        valores.put("bairro", endereco.getBairro());
        valores.put("numero", endereco.getNumero());
        valores.put("complemento", endereco.getComplemento());
        valores.put("frete", endereco.getFrete());

        escreve.insert(db.TABELA_ENDERECO, null, valores);
        codigo = buscarCodEndereco(endereco);

        return codigo;
    }

    public List<Endereco> listarEnderecos() {
        List<Endereco> listaEndereco = new ArrayList<>();
        Endereco endereco;
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

                endereco = new Endereco();
                endereco.setCodEndereco(codigo);
                endereco.setRua(rua);
                endereco.setBairro(bairro);
                endereco.setNumero(numero);
                endereco.setComplemento(complemento);
                endereco.setFrete(frete);

                listaEndereco.add(endereco);

                Log.i("id: ", codigo + " rua: " + rua + " bairro: " + bairro + " numero: " + numero +
                        " complemento: " + complemento + " frete: " + frete);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
        return listaEndereco;
    }

    public int buscarCodEndereco(Endereco endereco) {
        int codigo = 0;
        try {
            String consulta = "SELECT cod_endereco FROM endereco WHERE rua = '" + endereco.getRua()+
                    "' AND bairro = '" + endereco.getBairro()+
                    "' AND numero = " + endereco.getNumero()+";";
            Cursor cursor = le.rawQuery(consulta, null);

            int indiceCodigo = cursor.getColumnIndex("cod_endereco");

            cursor.moveToFirst();
            codigo = cursor.getInt(indiceCodigo);
        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
        return codigo;
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

            cursor.moveToFirst();

            String rua = cursor.getString(indiceRua);
            String bairro = cursor.getString(indiceBairro);
            int numero = cursor.getInt(indiceNumero);
            String complemento = cursor.getString(indiceComplemento);
            double frete = cursor.getDouble(indiceFrete);

            endereco = new Endereco();

            endereco.setCodEndereco(cod_endereco);
            endereco.setRua(rua);
            endereco.setBairro(bairro);
            endereco.setNumero(numero);
            endereco.setComplemento(complemento);
            endereco.setFrete(frete);

            Log.i("id: ", cod_endereco + " rua: " + rua + " bairro: " + bairro + " numero: " + numero +
                    " complemento: " + complemento + " frete: " + frete);
        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
        return endereco;
    }

    public void atualizarEndereco(Endereco endereco) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("rua", endereco.getRua());
            valores.put("bairro", endereco.getBairro());
            valores.put("numero", endereco.getNumero());
            valores.put("complemento", endereco.getComplemento());
            valores.put("frete", endereco.getFrete());

            String[] codigo = {String.valueOf(endereco.getCodEndereco())};
            escreve.update("endereco", valores, "cod_endereco = ?", codigo);

        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
    }

    public void deletarEndereco(int cod_endereco) {
        Endereco endereco;
        try {
            String[] codigo = {String.valueOf(cod_endereco)};
            escreve.delete("endereco", "cod_endereco = ?", codigo);
        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
    }
}
