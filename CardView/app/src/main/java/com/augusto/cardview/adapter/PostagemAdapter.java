package com.augusto.cardview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.augusto.cardview.R;
import com.augusto.cardview.model.Postagem;

import java.util.List;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder> {

    private List<Postagem> postagens;

    public PostagemAdapter(List<Postagem> listaPostagens) {
        this.postagens = listaPostagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.postagem_detalhe, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Postagem postagem = postagens.get(position);

        holder.textNome.setText(postagem.getNome());
        holder.postagem.setText(postagem.getPostagem());
        holder.imagem.setImageResource(postagem.getImagem());

    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textNome;
        private ImageView imagem;
        private TextView postagem;

        MyViewHolder(View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textNome);
            imagem = itemView.findViewById(R.id.imagePostagem);
            postagem = itemView.findViewById(R.id.textPostagem);

        }
    }
}
