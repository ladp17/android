package com.example.bd_activitie;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper {

    public static final String TABELA = "Tabela";
    public static final String ID = "_id";
    public static final String NOME = "Nome";

    private static final String DATABASE_NAME = "Database";
    private static final int DATABASE_VERSION = 1;

    //talvez tenha mais coisa pro lado ali sla
    private static final String DATABASE_CREATE = "create table " + TABELA + " ( " + ID + " INTEGER PRIMARY KEY, " + NOME + " TEXT NOT NULL );";

    public BD(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

    }


}
