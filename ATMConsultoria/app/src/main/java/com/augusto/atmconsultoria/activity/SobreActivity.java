package com.augusto.atmconsultoria.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.augusto.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sobre);

//        String descricao = "Texto de descricao bla bla";

        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
//                .setDescription(descricao)
                .addGroup("Fale Conosco")
                .addEmail("atmconsultoria@gmail.com", "Envie um Email")
                .addWebsite("www.google.com.br", "Acesse nosso site")
                .addGroup("Redes Sociais")
                .addFacebook("google", "Facebook")
                .addTwitter("google", "Twitter")
                .addYoutube("google", "Youtube")
                .addPlayStore("com.google.android.apps.plus", "Play Store")
                .addGitHub("auugustocesar", "GitHub")
                .addInstagram("google", "Instagram")
                .create();

        setContentView(sobre);
    }
}
