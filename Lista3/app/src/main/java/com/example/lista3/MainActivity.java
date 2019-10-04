package com.example.lista3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String[] nomes = {"logo", "wallpaper"};

    Integer[] imageID = {R.drawable.logo, R.drawable.wallpaper};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListCell cell = new ListCell(MainActivity.this, nomes, imageID);
        list = (ListView) findViewById(R.id.list);

        list = (ListView) findViewById(R.id.list);
        list.setAdapter(cell);

        list.setOnItemClickListener(listener);

    }

    AdapterView.OnItemClickListener listener= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(MainActivity.this, "teste", Toast.LENGTH_SHORT).show();

            Intent it = new Intent(MainActivity.this, ElementoActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("nome", nomes[position]);
            bundle.putInt("imageID", imageID[position]);

            it.putExtras(bundle);

            startActivity(it);

        }
    };

}
