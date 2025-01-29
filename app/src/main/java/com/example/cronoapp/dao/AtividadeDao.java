package com.example.cronoapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cronoapp.database.DatabaseHelper;
import com.example.cronoapp.model.Atividade;

import java.util.ArrayList;
import java.util.List;

public class AtividadeDao {
    private SQLiteDatabase db;

    public AtividadeDao(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long inserir(Atividade atividade) {
        ContentValues values = new ContentValues();
        values.put("nome", atividade.getNome());
        values.put("data_inicio", atividade.getDataHoraInicio());
        values.put("data_fim", atividade.getDataHoraFim());
        values.put("observacao", atividade.getObservacao());
        values.put("posto_id", atividade.getPostoTrabalho().getId());
        values.put("maquina_id", atividade.getMaquina().getId());
        return db.insert("Atividade", null, values);
    }

    public List<Atividade> listar() {
        List<Atividade> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Atividade", null);
        if (cursor.moveToFirst()) {
            do {
                lista.add(new Atividade(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), null, null, null));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    public void deletar(int id) {
        db.delete("Atividade", "id = ?", new String[]{String.valueOf(id)});
    }
}
