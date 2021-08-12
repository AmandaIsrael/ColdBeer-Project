package com.example.coldbeer.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.coldbeer.help.DbGateway;
import com.example.coldbeer.help.DbHelper;
import com.example.coldbeer.model.Cliente;

import java.util.ArrayList;
import java.util.List;

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

    public int inserirCliente(Cliente cliente){
        ContentValues valores;
        long resultado;

        valores = new ContentValues();
        valores.put("nome", cliente.getNome());
        valores.put("email", cliente.getEmail());
        valores.put("senha", cliente.getSenha());
        valores.put("telefone", cliente.getTelefone());
        valores.put("idade", cliente.getIdade());
        valores.put("cod_endereco", cliente.getCodEndereco());

        resultado = escreve.insert(db.TABELA_CLIENTE, null, valores);
        //db.close();

        if(resultado == -1){
            return (0); //deu erro
        }else{
            return (1); //deu bom
        }
    }

    public List<Cliente> listarClientes(){
        List<Cliente> listaCliente = new ArrayList<>();
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

                Cliente cliente = new Cliente();
                cliente.setCodCliente(codigo);
                cliente.setEmail(email);
                cliente.setSenha(senha);
                cliente.setNome(nome);
                cliente.setTelefone(telefone);
                cliente.setIdade(idade);
                cliente.setCodEndereco(cod_endereco);

                listaCliente.add(cliente);

                Log.i("id: ", codigo + " email: " + email + " senha: " + senha + " nome: " + nome +
                        " telefone: " + telefone + " idade: " + idade + " cod_endereco: "+cod_endereco);
                cursor.moveToNext();
            }
        }catch (Exception e){
            Log.i("info", "erro");
            e.printStackTrace();
        }
        return listaCliente;
    }

    public Cliente buscarCliente(int cod_cliente){
        Cliente cliente = null;
        try {
            String consulta = "SELECT * FROM cliente WHERE cod_cliente = " + cod_cliente;
            Cursor cursor = le.rawQuery(consulta, null);

            int indiceCodigo = cursor.getColumnIndex("cod_cliente");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceSenha = cursor.getColumnIndex("senha");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceTelefone = cursor.getColumnIndex("telefone");
            int indiceIdade = cursor.getColumnIndex("idade");
            int indiceCodEndereco = cursor.getColumnIndex("cod_endereco");

            cursor.moveToFirst();

            int codigo = cursor.getInt(indiceCodigo);
            String email = cursor.getString(indiceEmail);
            String senha = cursor.getString(indiceSenha);
            String nome = cursor.getString(indiceNome);
            String telefone = cursor.getString(indiceTelefone);
            int idade = cursor.getInt(indiceIdade);
            int cod_endereco = cursor.getInt(indiceCodEndereco);

            cliente = new Cliente();

            cliente.setCodEndereco(codigo);
            cliente.setEmail(email);
            cliente.setSenha(senha);
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setIdade(idade);
            cliente.setCodEndereco(cod_endereco);

            Log.i("id: ", codigo + " email: " + email + " senha: " + senha + " nome: " + nome +
                    " telefone: " + telefone + " idade: " + idade + " cod_endereco: "+ cod_endereco);
        }catch (Exception e){
            Log.i("info", "erro");
            e.printStackTrace();
        }
        return cliente;
    }

    public Cliente clienteLogin(String emailP, String senhaP){
        Cliente cliente = null;
        try {
            String consulta = "SELECT * FROM cliente WHERE email = '" + emailP+
                    "' AND senha = '"+ senhaP+"';";
            Cursor cursor = le.rawQuery(consulta, null);

            int indiceCodigo = cursor.getColumnIndex("cod_cliente");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceSenha = cursor.getColumnIndex("senha");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceTelefone = cursor.getColumnIndex("telefone");
            int indiceIdade = cursor.getColumnIndex("idade");
            int indiceCodEndereco = cursor.getColumnIndex("cod_endereco");

            cursor.moveToFirst();

            int codigo = cursor.getInt(indiceCodigo);
            String email = cursor.getString(indiceEmail);
            String senha = cursor.getString(indiceSenha);
            String nome = cursor.getString(indiceNome);
            String telefone = cursor.getString(indiceTelefone);
            int idade = cursor.getInt(indiceIdade);
            int cod_endereco = cursor.getInt(indiceCodEndereco);

            cliente = new Cliente();

            cliente.setCodEndereco(codigo);
            cliente.setEmail(email);
            cliente.setSenha(senha);
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setIdade(idade);
            cliente.setCodEndereco(cod_endereco);

            Log.i("id: ", codigo + " email: " + email + " senha: " + senha + " nome: " + nome +
                    " telefone: " + telefone + " idade: " + idade + " cod_endereco: "+ cod_endereco);
        }catch (Exception e){
            Log.i("info", "erro");
            e.printStackTrace();
        }
        return cliente;
    }

    public void atualizarCliente(Cliente cliente) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("email", cliente.getEmail());
            valores.put("senha", cliente.getSenha());
            valores.put("nome", cliente.getNome());
            valores.put("telefone", cliente.getTelefone());
            valores.put("idade", cliente.getIdade());
            valores.put("cod_endereco", cliente.getCodEndereco());

            String[] codigo = {String.valueOf(cliente.getCodCliente())};
            escreve.update("cliente", valores, "cod_cliente = ?", codigo);

        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
    }

    public void deletarCliente(int cod_cliente) {
        Cliente cliente;
        try {
            String[] codigo = {String.valueOf(cod_cliente)};
            escreve.delete("cliente", "cod_cliente = ?", codigo);
        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
    }
}
