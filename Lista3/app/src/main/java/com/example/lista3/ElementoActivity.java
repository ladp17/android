package com.example.lista3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ElementoActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elemento);


        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        Intent it = getIntent();

        if (it != null) {

            Bundle bundle = it.getExtras();

            if (bundle != null) {

                textView.setText(bundle.getString("nome"));
                imageView.setImageResource(bundle.getInt("imageID"));

            }

        }

    }

    public void onStop(){
        super.onStop();
        finish();
    }
}
