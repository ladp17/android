package com.example.bd_activitie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    BDControler controler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    protected void onStart() {
        super.onStart();

        controler = new BDControler(this);
        controler.open();
//        controler.addNome("teste1");
//        controler.addNome("teste2");
//        System.out.println("nomes add com sucesso");

        System.out.println(controler.getNome(1));
        System.out.println(controler.getNome(2));
        System.out.println(controler.getNome(3));

    }

    protected void onStop() {

        controler.close();

    }

}
