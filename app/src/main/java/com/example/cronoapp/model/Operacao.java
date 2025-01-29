package com.example.cronoapp.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "operacao")
public class Operacao {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nome;
    private String descricao;
    private String classificacao;

    public Operacao(int anInt, String nome, String descricao, String classificacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.classificacao = classificacao;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getClassificacao() { return classificacao; }
}