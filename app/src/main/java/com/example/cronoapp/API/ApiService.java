package com.example.cronoapp.API;

import com.example.cronoapp.model.Maquina;
import com.example.cronoapp.model.Operacao;
import com.example.cronoapp.model.PostoDeTrabalho;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("postos/postolist/")
    Call<List<PostoDeTrabalho>> getPostos();

    @GET("maquinas/maquinalist/")
    Call<List<Maquina>> getMaquinas();

    @GET("operacoes/operacaolist/")
    Call<List<Operacao>> getOperacoes();
}