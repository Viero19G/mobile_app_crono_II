package com.example.cronoapp.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.example.cronoapp.dao.AtividadeDao;
import com.example.cronoapp.dao.MaquinaDao;
import com.example.cronoapp.dao.OperacaoDao;
import com.example.cronoapp.dao.PostoDeTrabalhoDao;
import com.example.cronoapp.model.Atividade;
import com.example.cronoapp.model.Maquina;
import com.example.cronoapp.model.Operacao;
import com.example.cronoapp.model.PostoDeTrabalho;

@Database(entities = {PostoDeTrabalho.class, Maquina.class, Operacao.class, Atividade.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract PostoDeTrabalhoDao postoDeTrabalhoDao();
    public abstract MaquinaDao maquinaDao();
    public abstract OperacaoDao operacaoDao();
    public abstract AtividadeDao atividadeDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
