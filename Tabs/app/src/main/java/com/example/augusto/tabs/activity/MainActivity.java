package com.example.augusto.tabs.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.augusto.tabs.Fragment.EmAltaFragment;
import com.example.augusto.tabs.Fragment.HomeFragment;
import com.example.augusto.tabs.Fragment.InscricoesFragment;
import com.example.augusto.tabs.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        smartTabLayout = findViewById(R.id.viewPagerTab);

        //Aplica configuracoes na action bar
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("YouTube");

        // Configurar Abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment.class)
                        .add("Inscrições", InscricoesFragment.class)
                        .add("Em Alta", EmAltaFragment.class)
                        .create()
        );

        viewPager.setAdapter(adapter);

        smartTabLayout.setViewPager(viewPager);
    }
}
