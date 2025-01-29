package com.example.cronoapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cronoapp.database.DatabaseHelper;
import com.example.cronoapp.model.Maquina;

import java.util.ArrayList;
import java.util.List;

public class MaquinaDao {
    private SQLiteDatabase db;

    public MaquinaDao(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long inserir(Maquina maquina) {
        ContentValues values = new ContentValues();
        values.put("nome", maquina.getNome());
        values.put("descricao", maquina.getDescricao());
        return db.insert("Maquina", null, values);
    }

    public List<Maquina> listar() {
        List<Maquina> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Maquina", null);
        if (cursor.moveToFirst()) {
            do {
                lista.add(new Maquina(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    public void deletar(int id) {
        db.delete("Maquina", "id = ?", new String[]{String.valueOf(id)});
    }
}
