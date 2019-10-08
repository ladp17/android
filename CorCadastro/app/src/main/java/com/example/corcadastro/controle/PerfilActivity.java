package com.example.corcadastro.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.corcadastro.R;
import com.example.corcadastro.com.example.corcadastro.modelo.Cliente;
import com.example.corcadastro.com.example.corcadastro.modelo.dao.ClienteDAO;

public class PerfilActivity extends AppCompatActivity {

    TextView nomeTextView;

    SeekBar seekBarR;
    SeekBar seekBarG;
    SeekBar seekBarB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nomeTextView = findViewById(R.id.nome);

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

//            talvez eu queria usar o setBackgroundColor
//            nomeTextView.setTextColor(getResources(Color.parseColor(Controle.calculaCor())));
//            nomeTextView.setTextColor(ContextCompat.getColor(Controle.calculaCor(seekBarR.getProgress(), seekBarG.getProgress(), seekBarB.getProgress())));
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

    public void onClick() {
        Cliente cliente = new Cliente();

        if (cliente == null) {

            Toast.makeText(this, "cliente nulo", Toast.LENGTH_SHORT).show();
            return;

        } else {

            ClienteDAO cDAO = new ClienteDAO();
            cDAO.salvar(cliente);

        }

    }

}
