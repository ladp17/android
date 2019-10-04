package com.example.lista3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListCell extends ArrayAdapter {

    Activity context;
    String[] nomes;
    Integer[] imageID;

    public ListCell(Activity context, String[] nomes, Integer[] imageID) {

        super(context, R.layout.list_cell, nomes);

        this.context = context;
        this.nomes = nomes;
        this.imageID = imageID;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_cell, null, true);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        textView.setText(nomes[position]);
        imageView.setImageResource(imageID[position]);

        return rowView;
    }
}
