package com.br.didox.API.DTOs;

import com.br.didox.API.interfaces.IObjectDTO;

public class ProfissionalDTO implements IObjectDTO {
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    private String observacao;
}
