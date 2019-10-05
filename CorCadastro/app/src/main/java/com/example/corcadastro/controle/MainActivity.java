package com.example.corcadastro.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.corcadastro.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(Controle.chamaActivity(this, PerfilActivity.class, new Bundle()));

    }

    protected void onStop() {
        super.onStop();
        finish();

    }

}
