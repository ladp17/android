package com.example.listactivitie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] itens = new String[] {"1", "2"};
        ArrayAdapter<String> array = new ArrayAdapter<>(this, android.R.layout.activity_list_item, itens);
        setListAdapter(array);

    }



}
