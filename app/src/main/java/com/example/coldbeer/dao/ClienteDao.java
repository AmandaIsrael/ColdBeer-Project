package com.example.coldbeer.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.coldbeer.help.DbGateway;
import com.example.coldbeer.help.DbHelper;
import com.example.coldbeer.model.Cliente;

public class ClienteDao {
    private SQLiteDatabase escreve;
    private SQLiteDatabase le;
    private DbHelper db;
    private DbGateway gatewayDb;

    public ClienteDao(Context context){
        gatewayDb = DbGateway.getInstance(context);
        escreve = gatewayDb.getDatabase(true);
        le = gatewayDb.getDatabase(false);
    }

    public String inserirCliente(Cliente cliente){
        ContentValues valores;
        long resultado;

        valores = new ContentValues();
        valores.put("nome", cliente.getNome());
        valores.put("email", cliente.getEmail());
        valores.put("senha", cliente.getSenha());
        valores.put("telefone", cliente.getTelefone());
        valores.put("idade", cliente.getIdade());

        resultado = escreve.insert(db.TABELA_CLIENTE, null, valores);
        db.close();

        if(resultado == -1){
            return ("Erro ao inserir na tabela cliente!");
        }else{
            return ("Registro inserido com sucesso!");
        }
    }

    public void listarClientes(){
        try {
            String consulta = "SELECT * FROM cliente";
            Cursor cursor = le.rawQuery(consulta, null);

            int indiceCodigo = cursor.getColumnIndex("cod_cliente");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceSenha = cursor.getColumnIndex("senha");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceTelefone = cursor.getColumnIndex("telefone");
            int indiceIdade = cursor.getColumnIndex("idade");
            int indiceCodEndereco = cursor.getColumnIndex("cod_endereco");

            cursor.moveToFirst();

            while (cursor != null) {
                int codigo = cursor.getInt(indiceCodigo);
                String email = cursor.getString(indiceEmail);
                String senha = cursor.getString(indiceSenha);
                String nome = cursor.getString(indiceNome);
                String telefone = cursor.getString(indiceTelefone);
                int idade = cursor.getInt(indiceIdade);
                int cod_endereco = cursor.getInt(indiceCodEndereco);

                Log.i("id: ", codigo + " email: " + email + " senha: " + senha + " nome: " + nome +
                        " telefone: " + telefone + " idade: " + idade + " cod_endereco: " + cod_endereco);
                cursor.moveToNext();
            }
        }catch (Exception e){
            Log.i("info", "erro");
            e.printStackTrace();
        }
    }
}
