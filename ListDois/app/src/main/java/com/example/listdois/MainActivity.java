package com.example.listdois;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] itens = new String[] {"um", "dois"};

        ArrayAdapter<String> array = new ArrayAdapter<>(this, android.R.layout.activity_list_item, itens);
        setListAdapter(array);
    }
}
