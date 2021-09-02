package com.example.coldbeer.controller;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coldbeer.R;
import com.example.coldbeer.model.Produto;
import java.util.List;

public class AdapterListaProdutos extends RecyclerView.Adapter<AdapterListaProdutos.MyViewHolder>  {
    private List<Produto> listProduto;
    private int[] imagens;

    public AdapterListaProdutos(List<Produto> lista, int[] imagens){
        this.listProduto = lista;
        this.imagens = imagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.caixinha_produto, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int index = imagens[position];
        Produto produto = listProduto.get(position);
        holder.nome.setText(produto.getNome());
        holder.preco.setText(produto.getPrecoUnitario()+"");
        holder.fotoProduto.setImageResource(index);
    }

    @Override
    public int getItemCount() {
        return listProduto.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView preco;
        ImageView fotoProduto;

        public MyViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txtNome1);
            preco = itemView.findViewById(R.id.txtPreco1);
            fotoProduto = itemView.findViewById(R.id.imgFotoProduto);
        }
    }
}
