package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Boolean buttonState = true;

    private TextView textView;

    private Button button;

    Async cronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (buttonState) {

            //aqui da play no cronometro
            cronometro = new Async(textView, button);

            cronometro.execute(50);


        } else {

            cronometro.cancel(true);

        }

        buttonState = !buttonState;

    }

}
