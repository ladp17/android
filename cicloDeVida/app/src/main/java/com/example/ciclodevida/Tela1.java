package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela1 extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        Intent it = getIntent();

        if (it != null) {

            Bundle bundle = it.getExtras();

            if (bundle != null) {

                editText.setText(bundle.getString("texto"));

            }

        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent it = getIntent();

        if (it != null) {

            Bundle bundle = it.getExtras();

            if (bundle != null) {

                editText.setText(bundle.getString("texto"));

            }

        }


    }

    public void onClick(View view) {

        Intent it = new Intent(this, Tela2.class);

        Bundle bundle = new Bundle();
        bundle.putString("texto", editText.getText().toString());

        it.putExtras(bundle);

        startActivity(it);

    }

}
