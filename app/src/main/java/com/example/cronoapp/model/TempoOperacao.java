package com.example.cronoapp.model;


public class TempoOperacao {
    private int id;
    private Atividade atividade;
    private Operacao operacao;
    private int tempo; // Tempo em segundos

    public TempoOperacao(int id, Atividade atividade, Operacao operacao, int tempo) {
        this.id = id;
        this.atividade = atividade;
        this.operacao = operacao;
        this.tempo = tempo;
    }

    public TempoOperacao(Atividade atividade, Operacao operacao, int tempo) {
        this.atividade = atividade;
        this.operacao = operacao;
        this.tempo = tempo;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Atividade getAtividade() { return atividade; }
    public void setAtividade(Atividade atividade) { this.atividade = atividade; }

    public Operacao getOperacao() { return operacao; }
    public void setOperacao(Operacao operacao) { this.operacao = operacao; }

    public int getTempo() { return tempo; }
    public void setTempo(int tempo) { this.tempo = tempo; }
}
