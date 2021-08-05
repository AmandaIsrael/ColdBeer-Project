package com.example.coldbeer.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.coldbeer.help.DbGateway;
import com.example.coldbeer.help.DbHelper;
import com.example.coldbeer.model.Cliente;
import com.example.coldbeer.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private SQLiteDatabase escreve;
    private SQLiteDatabase le;
    private DbHelper db;
    private DbGateway gatewayDb;

    public ProdutoDao(Context context){
        gatewayDb = DbGateway.getInstance(context);
        escreve = gatewayDb.getDatabase(true);
        le = gatewayDb.getDatabase(false);
    }

    public String inserirProduto(Produto produto){
        ContentValues valores;
        long resultado;

        valores = new ContentValues();
        valores.put("nome", produto.getNome());
        valores.put("preco_unitario", produto.getPrecoUnitario());
        valores.put("categoria", produto.getCategoria());
        valores.put("teor_alcoolico", produto.getTeorAlcoolico());
        valores.put("descricao", produto.getDescricao());

        resultado = escreve.insert(db.TABELA_PRODUTO, null, valores);

        if(resultado == -1){
            return ("Erro ao inserir na tabela produto!");
        }else{
            return ("Registro inserido com sucesso!");
        }
    }

    public List<Produto> listarProdutos(){
        List<Produto> listaProduto = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM produto";
            Cursor cursor = le.rawQuery(consulta, null);

            int indiceCodigo = cursor.getColumnIndex("cod_produto");
            int indiceNome = cursor.getColumnIndex("nome");
            int indicePrecoUnitario = cursor.getColumnIndex("preco_unitario");
            int indiceCategoria = cursor.getColumnIndex("categoria");
            int indiceTeorAlcoolico = cursor.getColumnIndex("teor_alcoolico");
            int indiceDescricao = cursor.getColumnIndex("descricao");

            cursor.moveToFirst();

            while (cursor != null) {
                int codigo = cursor.getInt(indiceCodigo);
                String nome = cursor.getString(indiceNome);
                double precoUnit = cursor.getDouble(indicePrecoUnitario);
                boolean categoria = Boolean.parseBoolean(cursor.getString(indiceCategoria));
                String teorAlc = cursor.getString(indiceTeorAlcoolico);
                String descricao = cursor.getString(indiceDescricao);

                Produto produto = new Produto();
                produto.setCodProduto(codigo);
                produto.setNome(nome);
                produto.setPrecoUnitario(precoUnit);
                produto.setCategoria(categoria);
                produto.setTeorAlcoolico(teorAlc);
                produto.setDescricao(descricao);

                listaProduto.add(produto);

                Log.i("id: ", codigo + " nome: " + nome + " preco unitario: " + precoUnit + " categoria: " + categoria +
                        " teor alcoolico: " + teorAlc + " descricao: " + descricao);
                cursor.moveToNext();
            }
        }catch (Exception e){
            Log.i("info", "erro");
            e.printStackTrace();
        }
        return listaProduto;
    }

    public List<Produto> listarProdutosPorCategoria(Boolean categ){
        List<Produto> listaProduto = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM produto WHERE categoria = "+ categ;
            Cursor cursor = le.rawQuery(consulta, null);

            int indiceCodigo = cursor.getColumnIndex("cod_produto");
            int indiceNome = cursor.getColumnIndex("nome");
            int indicePrecoUnitario = cursor.getColumnIndex("preco_unitario");
            int indiceCategoria = cursor.getColumnIndex("categoria");
            int indiceTeorAlcoolico = cursor.getColumnIndex("teor_alcoolico");
            int indiceDescricao = cursor.getColumnIndex("descricao");

            cursor.moveToFirst();

            while (cursor != null) {
                int codigo = cursor.getInt(indiceCodigo);
                String nome = cursor.getString(indiceNome);
                double precoUnit = cursor.getDouble(indicePrecoUnitario);
                boolean categoria = Boolean.parseBoolean(cursor.getString(indiceCategoria));
                String teorAlc = cursor.getString(indiceTeorAlcoolico);
                String descricao = cursor.getString(indiceDescricao);

                Produto produto = new Produto();
                produto.setCodProduto(codigo);
                produto.setNome(nome);
                produto.setPrecoUnitario(precoUnit);
                produto.setCategoria(categoria);
                produto.setTeorAlcoolico(teorAlc);
                produto.setDescricao(descricao);

                listaProduto.add(produto);

                Log.i("id: ", codigo + " nome: " + nome + " preco unitario: " + precoUnit + " categoria: " + categoria +
                        " teor alcoolico: " + teorAlc + " descricao: " + descricao);
                cursor.moveToNext();
            }
        }catch (Exception e){
            Log.i("info", "erro");
            e.printStackTrace();
        }
        return listaProduto;
    }

    public Produto buscarProduto(int cod_produto){
        Produto produto = null;
        try {
            String consulta = "SELECT * FROM produto WHERE cod_produto = " + cod_produto;
            Cursor cursor = le.rawQuery(consulta, null);

            int indiceCodigo = cursor.getColumnIndex("cod_produto");
            int indiceNome = cursor.getColumnIndex("nome");
            int indicePrecoUnitario = cursor.getColumnIndex("preco_unitario");
            int indiceCategoria = cursor.getColumnIndex("categoria");
            int indiceTeorAlcoolico = cursor.getColumnIndex("teor_alcoolico");
            int indiceDescricao = cursor.getColumnIndex("descricao");

            cursor.moveToFirst();

            int codigo = cursor.getInt(indiceCodigo);
            String nome = cursor.getString(indiceNome);
            double precoUnit = cursor.getDouble(indicePrecoUnitario);
            boolean categoria = Boolean.parseBoolean(cursor.getString(indiceCategoria));
            String teorAlc = cursor.getString(indiceTeorAlcoolico);
            String descricao = cursor.getString(indiceDescricao);

            produto = new Produto();
            produto.setCodProduto(codigo);
            produto.setNome(nome);
            produto.setPrecoUnitario(precoUnit);
            produto.setCategoria(categoria);
            produto.setTeorAlcoolico(teorAlc);
            produto.setDescricao(descricao);

            Log.i("id: ", codigo + " nome: " + nome + " preco unitario: " + precoUnit + " categoria: " + categoria +
                    " teor alcoolico: " + teorAlc + " descricao: " + descricao);
        }catch (Exception e){
            Log.i("info", "erro");
            e.printStackTrace();
        }
        return produto;
    }

    public void atualizarProduto(Produto produto) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("nome", produto.getNome());
            valores.put("preco_unitario", produto.getPrecoUnitario());
            valores.put("categoria", produto.getCategoria());
            valores.put("teor_alcoolico", produto.getTeorAlcoolico());
            valores.put("descricao", produto.getDescricao());

            String[] codigo = {String.valueOf(produto.getCodProduto())};
            escreve.update("produto", valores, "cod_produto = ?", codigo);

        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
    }

    public void deletarProduto(int cod_produto) {
        Produto produto;
        try {
            String[] codigo = {String.valueOf(cod_produto)};
            escreve.delete("produto", "cod_produto = ?", codigo);
        } catch (Exception e) {
            Log.i("info", "erro");
            e.printStackTrace();
        }
    }
}
