package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
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
        gorjetaTextView.setText("R$0.00");

        contaEditText.addTextChangedListener(contaListener);
        gorjetaSeekBar.setOnSeekBarChangeListener(gorjetaListener);


    }

    private TextWatcher contaListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {

                Double result = calculaGorjeta(Double.valueOf(contaEditText.getText().toString()), Double.valueOf(gorjetaSeekBar.getProgress()));
                gorjetaTextView.setText(String.format("R$%.02f", result));

            } catch (Exception e) {

                gorjetaTextView.setText(String.format("R$%.02f", 0.00));
                System.out.println("campo editText vaziu");
                e.printStackTrace();

            }

        }

        @Override
        public void afterTextChanged(Editable s) {

            try {

                Double result = calculaGorjeta(Double.valueOf(contaEditText.getText().toString()), Double.valueOf(gorjetaSeekBar.getProgress()));
                gorjetaTextView.setText(String.format("R$%.02f", result));

            } catch (Exception e) {

                System.out.println("campo editText vaziu");
                e.printStackTrace();

            }

        }
    };

    private SeekBar.OnSeekBarChangeListener gorjetaListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            porcentagemTextView.setText(String.valueOf(progress + "%"));


                try {

                    Double result = calculaGorjeta(Double.valueOf(contaEditText.getText().toString()), Double.valueOf(progress));
                    gorjetaTextView.setText(String.format("R$%.02f", result));

                } catch (Exception e) {

                    System.out.println("campo editText vaziu");
                    e.printStackTrace();

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
