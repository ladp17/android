package com.example.helloname;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.nomeEditText);
        textView = (TextView) findViewById(R.id.textView5);
        editText.addTextChangedListener(nomeTextWatcher);

    }

    private TextWatcher nomeTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            attMsg();

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void attMsg() {

        String nome = editText.getText().toString();
        textView.setText("O seu nome eh: " + nome);

    }

}
