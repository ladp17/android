package com.example.churrascometro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar menSeekBar;
    SeekBar womenSeekBar;
    SeekBar childSeekBar;
    TextView menTextView;
    TextView womenTextView;
    TextView childrenTextView;
    TextView outputSausage;
    TextView outputMeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menSeekBar = (SeekBar) findViewById(R.id.menSeekBar);
        womenSeekBar = (SeekBar) findViewById(R.id.womenSeekBar);
        childSeekBar = (SeekBar) findViewById(R.id.childrenSeekBar);
        menTextView  = (TextView) findViewById(R.id.menTextView);
        womenTextView  = (TextView) findViewById(R.id.womenTextView);
        childrenTextView  = (TextView) findViewById(R.id.childrenTextView2);
        outputSausage  = (TextView) findViewById(R.id.saussageTextView);
        outputMeat  = (TextView) findViewById(R.id.meatTextView);

        menSeekBar.setOnSeekBarChangeListener(menListener);
        womenSeekBar.setOnSeekBarChangeListener(womenListener);
        childSeekBar.setOnSeekBarChangeListener(childrenListener);

    }

    private SeekBar.OnSeekBarChangeListener menListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        menTextView.setText("men: " + progress);
        calcular(progress, womenSeekBar.getProgress(), childSeekBar.getProgress());

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private SeekBar.OnSeekBarChangeListener womenListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            womenTextView.setText("women: " + progress);
            calcular(menSeekBar.getProgress(), progress, childSeekBar.getProgress());

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private SeekBar.OnSeekBarChangeListener childrenListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            childrenTextView.setText("children: " + progress);
            calcular(menSeekBar.getProgress(), womenSeekBar.getProgress(), progress);

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public void calcular (Integer men, Integer women, Integer children) {

        Integer resultSaussage = men * 350 + women * 250 + children * 200;
        Integer resultMeat = men * 500 + women * 350 + children * 250;

        outputSausage.setText("Saussage: " + resultSaussage / 1000D + "Kg");
        outputMeat.setText("Meat: " + resultMeat / 1000D + "Kg");

    }

}
