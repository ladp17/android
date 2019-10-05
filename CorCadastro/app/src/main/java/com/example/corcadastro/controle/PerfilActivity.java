package com.example.corcadastro.controle;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.icu.text.CompactDecimalFormat;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.corcadastro.R;

public class PerfilActivity extends AppCompatActivity {

    TextView textView;

    SeekBar seekBarR;
    SeekBar seekBarG;
    SeekBar seekBarB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        textView = findViewById(R.id.textView);

        seekBarR = findViewById(R.id.seekBarR);
        seekBarG = findViewById(R.id.seekBarG);
        seekBarB = findViewById(R.id.seekBarB);

        seekBarR.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBarG.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBarB.setOnSeekBarChangeListener(seekBarChangeListener);


    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            //talvez eu queria usar o setBackgroundColor
            textView.setTextColor(getResources(Color.parseColor(Controle.calculaCor())));

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    protected void onStop() {
        super.onStop();
        finish();

    }

}
