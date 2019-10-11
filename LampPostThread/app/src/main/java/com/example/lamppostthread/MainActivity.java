package com.example.lamppostthread;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer i = 0;

    Boolean buttonState = false;

    TextView textViewGreen;
    TextView textViewYellow;
    TextView textViewRed;

    TextView textViewCronometro;

    Button button;

    Handler handler = new Handler();

    Runnable curentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewGreen = findViewById(R.id.textViewGreen);
        textViewYellow = findViewById(R.id.textViewYellow);
        textViewRed = findViewById(R.id.textViewRed);

        textViewCronometro = findViewById(R.id.textViewCronometro);

        curentState = green;

        button = findViewById(R.id.button);

        button.setOnClickListener(onClickListener);

    }

    Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (buttonState) {

                buttonState = false;

                handler.removeCallbacks(green);
                handler.removeCallbacks(yellow);
                handler.removeCallbacks(red);

                handler.removeCallbacks(cronometro);

            } else {

                buttonState = true;

//                textViewGreen.setBackgroundColor(Color.WHITE);
//                textViewYellow.setBackgroundColor(Color.WHITE);
//                textViewRed.setBackgroundColor(Color.WHITE);

                handler.post(cronometro);

                handler.post(curentState);

            }

        }
    };

    Runnable cronometro = new Runnable() {
        @Override
        public void run() {

            i++;
            textViewCronometro.setText(i.toString());
            handler.postDelayed(cronometro, 1000);

        }
    };

    Runnable green = new Runnable() {
        @Override
        public void run() {

            curentState = this;
            textViewRed.setBackgroundColor(Color.WHITE);
            textViewGreen.setBackgroundColor(Color.GREEN);
            handler.postDelayed(yellow, 500);
        }
    };

    Runnable yellow = new Runnable() {
        @Override
        public void run() {

            curentState = this;
            textViewGreen.setBackgroundColor(Color.WHITE);
            textViewYellow.setBackgroundColor(Color.YELLOW);
            handler.postDelayed(red, 500);

        }
    };

    Runnable red = new Runnable() {
        @Override
        public void run() {

            curentState = this;
            textViewYellow.setBackgroundColor(Color.WHITE);
            textViewRed.setBackgroundColor(Color.RED);
            handler.postDelayed(green, 500);

        }
    };

}
