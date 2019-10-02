package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView contaTextView;
    EditText contaEditText;
    SeekBar gorjetaSeekBar;
    TextView porcentagemTextView;
    TextView gorjetaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contaTextView = findViewById(R.id.contaTextView);
        contaEditText = findViewById(R.id.contaEditText);
        gorjetaSeekBar = findViewById(R.id.gorjetaSeekBar);
        porcentagemTextView = findViewById(R.id.porcentagemTextView);
        gorjetaTextView = findViewById(R.id.gorjetaTextView);

        gorjetaSeekBar.setProgress(1);
        gorjetaSeekBar.setOnSeekBarChangeListener(gorjetaListener);


    }

    private SeekBar.OnSeekBarChangeListener gorjetaListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            porcentagemTextView.setText(String.valueOf(progress + "%"));
            if ( contaEditText.getText() == null || contaEditText.getText() == "") {

                Double result = calculaGorjeta(Double.valueOf(contaEditText.getText().toString()), Double.valueOf(progress));
//            gorjetaTextView.setText(result.toString());

            }


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public Double calculaGorjeta (Double conta, Double taxa) {

        taxa = taxa / 100;
        return conta * taxa;

    }

}
