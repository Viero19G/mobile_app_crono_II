package com.example.cronoapp.model;

public class TempoOperacao {
    private Operacao operacao;
    private int tempo; // Tempo em segundos

    public TempoOperacao(Operacao operacao, int tempo) {
        this.operacao = operacao;
        this.tempo = tempo;
    }

    // Getters e Setters
    public Operacao getOperacao() { return operacao; }
    public void setOperacao(Operacao operacao) { this.operacao = operacao; }

    public int getTempo() { return tempo; }
    public void setTempo(int tempo) { this.tempo = tempo; }
}
