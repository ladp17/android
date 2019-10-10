package com.example.bd_activitie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;

public class BDControler {

    BD bd;
    SQLiteDatabase database;
    private String[] TABELA_COLUNAS = {bd.ID, bd.NOME};

    public BDControler(Context context) {
        bd = new BD(context);

    }

    public void open() {

        database = bd.getWritableDatabase();

    }

    public void close() {

        bd.close();

    }

    public void addNome(String nome) {

        ContentValues values  = new ContentValues();
        values.put(bd.NOME, nome);

        database.insert(bd.TABELA, null, values);



    }

    public String getNome(int id) {


        Cursor cursor = database.query(bd.TABELA, TABELA_COLUNAS, bd.ID + " = " + 1, null, null, null, null
        );

        cursor.moveToNext();
        return cursor.getString(1);

    }

}
