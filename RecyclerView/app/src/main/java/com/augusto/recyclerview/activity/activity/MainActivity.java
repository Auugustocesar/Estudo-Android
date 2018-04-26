package com.augusto.recyclerview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.augusto.recyclerview.R;
import com.augusto.recyclerview.activity.RecyclerItemClickListener;
import com.augusto.recyclerview.activity.adapter.AdapterFilmes;
import com.augusto.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        // Listagem de Filme
        this.criarFilmes();

        // Configurar adapter
        AdapterFilmes adapterFilmes = new AdapterFilmes(listaFilmes);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterFilmes);

        //evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(), "Item pressionado: " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(), "Click Longo: " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );
    }

    public void criarFilmes() {
        Filme filme = new Filme("Homem Aranha - De Volta ao lar", "2017", "Aventura");
        this.listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "2017", "Fantasia");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "2017", "Ficção");
        this.listaFilmes.add(filme);

        filme = new Filme("Capitão América - Gurra Civíl", "2016", "Aventura/Ficção");
        this.listaFilmes.add(filme);

        filme = new Filme("It: A Coisa", "2017", "Drama/Terror");
        this.listaFilmes.add(filme);

        filme = new Filme("Pica-Pau: O Filme", "2017", "Comédia/Animação");
        this.listaFilmes.add(filme);

        filme = new Filme("A Múmia", "2017", "Terror");
        this.listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "2017", "Romance");
        this.listaFilmes.add(filme);

        filme = new Filme("Meu malvado favorito 3", "2017", "Comédia");
        this.listaFilmes.add(filme);

        filme = new Filme("Carros 3", "2017", "Comédia");
        this.listaFilmes.add(filme);
    }
}
