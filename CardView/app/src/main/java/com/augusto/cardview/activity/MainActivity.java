package com.augusto.cardview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.augusto.cardview.R;
import com.augusto.cardview.adapter.PostagemAdapter;
import com.augusto.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Define Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerPostagem.setLayoutManager(layoutManager);

        //define Adapter
        this.prepararPostagens();
        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerPostagem.setAdapter(adapter);
    }

    public void prepararPostagens() {

        Postagem postagem;

        postagem = new Postagem("Augusto Cesar", "#tbt viagem", R.drawable.imagem1);
        postagens.add(postagem);

        postagem = new Postagem("Melyna Algayer", "viagem maneira", R.drawable.imagem2);
        postagens.add(postagem);

        postagem = new Postagem("IOmagem 3", "viagem maneira ad", R.drawable.imagem3);
        postagens.add(postagem);

        postagem = new Postagem("Melyna Algayer", "viagem maneira", R.drawable.imagem4);
        postagens.add(postagem);

    }
}
