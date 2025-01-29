package com.example.cronoapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cronoapp.database.DatabaseHelper;
import com.example.cronoapp.model.PostoDeTrabalho;

import java.util.ArrayList;
import java.util.List;

public class PostoDeTrabalhoDao {
    private SQLiteDatabase db;

    public PostoDeTrabalhoDao(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long inserir(PostoDeTrabalho posto) {
        ContentValues values = new ContentValues();
        values.put("nome", posto.getNome());
        values.put("descricao", posto.getDescricao());
        return db.insert("PostoTrabalho", null, values);
    }

    public List<PostoDeTrabalho> listar() {
        List<PostoDeTrabalho> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM PostoTrabalho", null);
        if (cursor.moveToFirst()) {
            do {
                lista.add(new PostoDeTrabalho(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    public void deletar(int id) {
        db.delete("PostoTrabalho", "id = ?", new String[]{String.valueOf(id)});
    }
}
