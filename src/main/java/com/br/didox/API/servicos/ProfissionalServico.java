package com.br.didox.API.servicos;

import java.util.ArrayList;
import java.util.List;

import com.br.didox.API.models.Profissional;

public class ProfissionalServico {

    private ProfissionalServico() { }
    private List<Profissional> profissionais;
    private static ProfissionalServico profissionalServico;

    public static ProfissionalServico getInstancia(){
        if(profissionalServico == null) 
            profissionalServico = new ProfissionalServico();
        return profissionalServico;
    }

    public List<Profissional> getProfissionais(){
        if(this.profissionais == null) 
            this.profissionais = new ArrayList<Profissional>();
        return this.profissionais;
    }

    public void adicionar(Profissional profissional){
        this.getProfissionais().add(profissional);
    }

    public Profissional buscaPorId(int id) {
        for (Profissional profFor : this.getProfissionais()) {
            if(profFor.getId() == id){
                return profFor;
            }
        }

        return null;
    }
}
