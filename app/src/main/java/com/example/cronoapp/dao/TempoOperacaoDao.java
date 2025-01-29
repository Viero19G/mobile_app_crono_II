package com.example.cronoapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cronoapp.database.DatabaseHelper;
import com.example.cronoapp.model.TempoOperacao;

import java.util.ArrayList;
import java.util.List;

public class TempoOperacaoDao {
    private SQLiteDatabase db;

    public TempoOperacaoDao(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // Inserir um novo TempoOperacao
    public long inserir(TempoOperacao tempoOperacao) {
        ContentValues values = new ContentValues();
        values.put("atividade_id", tempoOperacao.getAtividade().getId());
        values.put("operacao_id", tempoOperacao.getOperacao().getId());
        values.put("tempo", tempoOperacao.getTempo());

        return db.insert("TempoOperacao", null, values);
    }

    // Listar todos os TemposOperacao
    public List<TempoOperacao> listar() {
        List<TempoOperacao> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM TempoOperacao", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                int atividadeId = cursor.getInt(1);
                int operacaoId = cursor.getInt(2);
                int tempo = cursor.getInt(3);

                // Criamos um objeto TempoOperacao sem carregar os relacionamentos
                TempoOperacao tempoOperacao = new TempoOperacao(id, null, null, tempo);
                lista.add(tempoOperacao);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    // Atualizar um TempoOperacao existente
    public int atualizar(TempoOperacao tempoOperacao) {
        ContentValues values = new ContentValues();
        values.put("atividade_id", tempoOperacao.getAtividade().getId());
        values.put("operacao_id", tempoOperacao.getOperacao().getId());
        values.put("tempo", tempoOperacao.getTempo());

        return db.update("TempoOperacao", values, "id = ?", new String[]{String.valueOf(tempoOperacao.getId())});
    }

    // Deletar um TempoOperacao
    public void deletar(int id) {
        db.delete("TempoOperacao", "id = ?", new String[]{String.valueOf(id)});
    }
}
