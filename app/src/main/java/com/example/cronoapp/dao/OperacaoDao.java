package com.example.cronoapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cronoapp.database.DatabaseHelper;
import com.example.cronoapp.model.Operacao;

import java.util.ArrayList;
import java.util.List;

public class OperacaoDao {
    private SQLiteDatabase db;

    public OperacaoDao(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long inserir(Operacao operacao) {
        ContentValues values = new ContentValues();
        values.put("nome", operacao.getNome());
        values.put("descricao", operacao.getDescricao());
        values.put("classificacao", operacao.getClassificacao());
        return db.insert("Operacao", null, values);
    }

    public List<Operacao> listar() {
        List<Operacao> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Operacao", null);
        if (cursor.moveToFirst()) {
            do {
                lista.add(new Operacao(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    public void deletar(int id) {
        db.delete("Operacao", "id = ?", new String[]{String.valueOf(id)});
    }
}
