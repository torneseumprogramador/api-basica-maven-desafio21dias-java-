package com.br.didox.API.DTOs;

import com.br.didox.API.interfaces.IObjectDTO;

public class ProfissionalMinimoDTO implements IObjectDTO {
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
