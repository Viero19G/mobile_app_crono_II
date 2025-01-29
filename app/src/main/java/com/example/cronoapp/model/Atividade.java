package com.example.cronoapp.model;
import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "atividade")
public class Atividade {
    private int id;
    private String nome;
    private String dataHoraInicio;
    private String dataHoraFim;
    private String observacao;
    private PostoDeTrabalho postoTrabalho;
    private Maquina maquina;
    private List<TempoOperacao> tempos;  // Lista de tempos vinculados a operações

    public Atividade(int id, String nome, String dataHoraInicio, String dataHoraFim, String observacao,
                     PostoDeTrabalho postoTrabalho, Maquina maquina, List<TempoOperacao> tempos) {
        this.id = id;
        this.nome = nome;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.observacao = observacao;
        this.postoTrabalho = postoTrabalho;
        this.maquina = maquina;
        this.tempos = tempos;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDataHoraInicio() { return dataHoraInicio; }
    public void setDataHoraInicio(String dataHoraInicio) { this.dataHoraInicio = dataHoraInicio; }

    public String getDataHoraFim() { return dataHoraFim; }
    public void setDataHoraFim(String dataHoraFim) { this.dataHoraFim = dataHoraFim; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public PostoDeTrabalho getPostoTrabalho() { return postoTrabalho; }
    public void setPostoTrabalho(PostoDeTrabalho postoTrabalho) { this.postoTrabalho = postoTrabalho; }

    public Maquina getMaquina() { return maquina; }
    public void setMaquina(Maquina maquina) { this.maquina = maquina; }

    public List<TempoOperacao> getTempos() { return tempos; }
    public void setTempos(List<TempoOperacao> tempos) { this.tempos = tempos; }
}