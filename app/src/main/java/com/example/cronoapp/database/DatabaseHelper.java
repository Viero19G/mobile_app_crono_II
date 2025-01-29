package com.example.cronoapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "app_database.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PostoTrabalho (id INTEGER PRIMARY KEY, nome TEXT, descricao TEXT)");
        db.execSQL("CREATE TABLE Maquina (id INTEGER PRIMARY KEY, nome TEXT, descricao TEXT)");
        db.execSQL("CREATE TABLE Operacao (id INTEGER PRIMARY KEY, nome TEXT, descricao TEXT, classificacao TEXT)");
        db.execSQL("CREATE TABLE Atividade (id INTEGER PRIMARY KEY, nome TEXT, data_inicio TEXT, data_fim TEXT, observacao TEXT, posto_id INTEGER, maquina_id INTEGER, FOREIGN KEY(posto_id) REFERENCES PostoTrabalho(id), FOREIGN KEY(maquina_id) REFERENCES Maquina(id))");
        db.execSQL("CREATE TABLE TempoOperacao (id INTEGER PRIMARY KEY, atividade_id INTEGER, operacao_id INTEGER, tempo INTEGER, FOREIGN KEY(atividade_id) REFERENCES Atividade(id), FOREIGN KEY(operacao_id) REFERENCES Operacao(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TempoOperacao");
        db.execSQL("DROP TABLE IF EXISTS Atividade");
        db.execSQL("DROP TABLE IF EXISTS Operacao");
        db.execSQL("DROP TABLE IF EXISTS Maquina");
        db.execSQL("DROP TABLE IF EXISTS PostoTrabalho");
        onCreate(db);
    }
}
