package com.augusto.frasesdodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view) {

        String[] frases = {
                "Sou feliz por ser como sou, por ter o que tenho, mas amanhã quero ser ainda mais e para isso luto diariamente.",
                "Amar a vida é amar seus amigos, pois sem eles nada mais faz sentido no seu dia a dia.",
                "Nada melhor para a alma que treinar a gratidão e diariamente agradecer pelas bênçãos que receber.",
                "Nem toda mudança importante acontece de repente e faz barulho, algumas são silenciosas e vão se fazendo no dia a dia.",
                "Porque a vida é mágica, aproveite os milagres do dia a dia. Boa tarde!"
        };

        int numero = new Random().nextInt(frases.length);

        TextView texto = findViewById(R.id.text_resultado);

        texto.setText(frases[numero]);
    }
}
