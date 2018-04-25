package com.augusto.pedrapapeltesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textEscolha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEscolha = findViewById(R.id.textEscolha);
    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("pedra");
        textEscolha.setText("Voce Escolheu: Pedra ");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("papel");
        textEscolha.setText("Voce Escolheu: Papel");
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("tesoura");
        textEscolha.setText("Voce Escolheu: Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {
        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);

        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura")) ||
            (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra")) ||
            (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel"))
                ) { //App ganhador
            textResultado.setText("Você Perdeu :( ");
        } else if (
                (escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura")) ||
                (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra")) ||
                (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel"))
                ) { //Usuario ganhador
            textResultado.setText("Você ganhou :) ");
        } else { // Empate
            textResultado.setText("Empatamos :) ");
        }
    }

}
